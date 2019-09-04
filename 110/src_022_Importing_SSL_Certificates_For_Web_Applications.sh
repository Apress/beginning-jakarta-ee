#!/bin/bash

#Alias of the certificate
NAME=my_alias

#The domain registered in letsencrypt
DOMAIN=www.server.com

#The keystore password, default is <changeit>
KEYSTOREPW=changeit

#The full absolute path of the folder where you have put 
#the files received from letsencrypt
LIVE=/some/path/on/your/pc/$DOMAIN

mkdir temp-ssh-123
cd temp-ssh-123

# ### start building keystore.jks keystore ###############

# Create cert_and_key.p12 from private key and a 
# certificate from the CA confirming that the private 
# key belongs to the domain you were using while applying 
# for the certificate. PKCS12 is a standardized archive 
# format for cryptographic objects
openssl pkcs12 -export -in $LIVE/fullchain.pem \
  -inkey $LIVE/privkey.pem \
  -out cert_and_key.p12 \
  -name $NAME \
  -CAfile $LIVE/chain.pem -caname root \
  -password pass:$KEYSTOREPW

# Create a new keystore file keystore.jks from 
# cert_and_key.p12
keytool -importkeystore \
  -destkeystore keystore.jks \
  -srckeystore cert_and_key.p12 -srcstoretype PKCS12 \
  -alias $NAME \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# Add the certificate chain to keystore.jks
keytool -import -noprompt \
  -trustcacerts \
  -alias root \
  -file $LIVE/chain.pem -keystore keystore.jks \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# Create file pkcs.p12 containing the private key again, 
# this time use name "glassfish-instance". This is one 
# of the keys Glassfish uses for its normal functioning. 
openssl pkcs12 -export \
  -in $LIVE/fullchain.pem -inkey $LIVE/privkey.pem \
  -out pkcs.p12 \
  -name glassfish-instance \
  -password pass:$KEYSTOREPW

# ... Import exactly this key into keystore.jks
keytool -importkeystore -destkeystore keystore.jks \
  -srckeystore pkcs.p12 -srcstoretype PKCS12 \
  -alias glassfish-instance \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# And one more key Glassfish needs as a default key. This 
# time the name is "s1as".
openssl pkcs12 -export -in $LIVE/fullchain.pem \
  -inkey $LIVE/privkey.pem -out pkcs.p12 -name s1as \
  -password pass:$KEYSTOREPW

# ... Also import this one into keystore.jks
keytool -importkeystore \
  -destkeystore keystore.jks \
  -srckeystore pkcs.p12 -srcstoretype PKCS12 \
  -alias s1as \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# ### start building cacerts.jks keystore ################

# Create a new keystore file cacerts.jks from 
# cert_and_key.p12
keytool -importkeystore \
  -destkeystore cacerts.jks \
  -srckeystore cert_and_key.p12 -srcstoretype PKCS12 \
  -alias $NAME \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# Imports the chain.pem file into cacerts.jks 
keytool -import -noprompt -trustcacerts \
  -alias root -file $LIVE/chain.pem \
  -keystore cacerts.jks \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# Imports fullchain.pem into cacerts.jks, 
# use name glassfish-instance
openssl pkcs12 -export -in $LIVE/fullchain.pem \
  -inkey $LIVE/privkey.pem -out pkcs.p12 \
  -name glassfish-instance -password pass:$KEYSTOREPW
keytool -importkeystore -destkeystore cacerts.jks \
  -srckeystore pkcs.p12 -srcstoretype PKCS12 \
  -alias glassfish-instance \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# Imports privkey.pem into cacerts.jks, use name s1as
openssl pkcs12 -export -in $LIVE/fullchain.pem \
  -inkey $LIVE/privkey.pem -out pkcs.p12 -name s1as \
  -password pass:$KEYSTOREPW
keytool -importkeystore -destkeystore cacerts.jks \
  -srckeystore pkcs.p12 -srcstoretype PKCS12 \
  -alias s1as \
  -srcstorepass $KEYSTOREPW \
  -deststorepass $KEYSTOREPW \
  -destkeypass $KEYSTOREPW

# ========================================================
# Download latest list of cacert and import it into the 
# cacerts.jks

wget https://curl.haxx.se/ca/cacert.pem \
  --no-check-certificate -O cacert.pem
# number of certificates in the PEM file
CERTS=$(grep 'END CERTIFICATE' cacert.pem | wc -l)

# Extract all certificates from the PEM file and insert \
# them into cacerts.jks
for N in $(seq 0 $(($CERTS - 1))); do
  PEM_FILE=cacert.pem
  ALIAS="${PEM_FILE%.*}-$N"
  echo $ALIAS
  cat cacert.pem |
    awk "n==$N { print }; /END CERTIFICATE/ { n++ }" |
    keytool -noprompt -import -trustcacerts \
            -alias $ALIAS -keystore cacerts.jks \
            -storepass $KEYSTOREPW
done
