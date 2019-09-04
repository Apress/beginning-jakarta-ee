  cd [GLASSFISH_INST]
  cd bin
  ./asadmin create-jdbc-connection-pool \
     --datasourceclassname \
       org.apache.derby.jdbc.ClientDataSource \
     --restype javax.sql.DataSource \
     --property \
       portNumber=1527:password=pw715:user=user0:
       serverName=localhost:databaseName=calypso:
       securityMechanism=3 \ 
     Calypso
			
  ./asadmin create-jdbc-resource \
    --connectionpoolid Calypso jdbc/Calypso
