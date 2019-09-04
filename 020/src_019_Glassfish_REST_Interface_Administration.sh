curl -X GET -H "Accept: application/json" \
   http://localhost:4848/management/domain/version | jq .
curl -X GET -H "Accept: application/json" \
   http://localhost:4848/management/domain/uptime | jq .
