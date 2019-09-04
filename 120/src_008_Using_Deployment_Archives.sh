curl -X POST \
  -u admin:<PASSWORD> \
  -F 'id=@/path/to/the/ear/someApp.ear' \
  -H 'Accept: application/json' \
  -H 'X-Requested-By: dummy' \
  http://localhost:4848/management/
        domain/applications/application
