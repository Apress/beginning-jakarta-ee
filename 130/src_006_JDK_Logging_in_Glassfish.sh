  ./asadmin list-log-levels
  # -> A list of all log levels, like
  # javax                            <INFO>
  # javax.mail                       <INFO>
  # javax.org.glassfish.persistence  <INFO>
  # org.apache.catalina              <INFO>
  # org.apache.coyote                <INFO>
  # org.apache.jasper                <INFO>
  # ...

  ./asadmin delete-log-levels javax.mail
  # -> Deletes a level specification

  ./asadmin set-log-levels javax.mail=WARNING
  # -> Setting a specific log level

  ./asadmin list-log-attributes
  # -> Shows all log attributes (not the levels)

  ./asadmin set-log-attributes \
      com.sun.enterprise.server.logging.
      GFFileHandler.rotationLimitInBytes=2000000
  # (discard the line break after "logging.")
  # -> Sets an attribute. Attribute names are the same
  # as in the logging.properties file

  ./asadmin rotate-log
  # -> Manually rotates the log file. Takes the current 
  # server.log file, archives it and starts a fresh
  # empty server.log file.
