  cd [GLASSFISH_INST]
  cd bin
  ./asadmin list-jndi-entries

  # output for example:
  # UserTransaction: com.sun.enterprise.transaction...
  #   startup.TransactionLifecycleService$2
  # ejb: com.sun.enterprise.naming.impl.TransientContext
  # book.jakarta8.testEjbServer.SomeEjbRemote__3_x_
  #   Internal_RemoteBusinessHome__: javax.naming.Reference
  # java:global: com.sun.enterprise.naming.impl. 
  #   TransientContext
  # book.jakarta8.testEjbServer.SomeEjbRemote: 
  #   javax.naming.Reference
  # book.jakarta8.testEjbServer.SomeEjbRemote#book.
  #   jakarta8.testEjbServer.SomeEjbRemote: 
  #   javax.naming.Reference
  # jdbc: com.sun.enterprise.naming.impl.TransientContext
  # concurrent: com.sun.enterprise.naming.impl.
  #   TransientContext
  # com.sun.enterprise.container.common.spi.util.
  #   InjectionManager:   
  # com.sun.enterprise.container.common.impl.util.
  #   InjectionManagerImpl
  # jms: com.sun.enterprise.naming.impl.TransientContext
