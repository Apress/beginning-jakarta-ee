curl -X GET -H "Accept: application/json" \
  http://localhost:4848/management/domain/applications/
  list-applications?long=true | jq .
