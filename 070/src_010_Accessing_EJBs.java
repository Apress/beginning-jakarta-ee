    ...
    String remoteServerHost = "localhost";
    // or "192.168.1.111" or something
    String remoteServerPort = "3700";
    // Port 3700 is part of the Glassfish conf

    Properties props = new Properties();
    props.setProperty("java.naming.factory.initial",
      "com.sun.enterprise.naming."+
      "SerialInitContextFactory");
    props.setProperty("java.naming.factory.url.pkgs",
      "com.sun.enterprise.naming");
    props.setProperty("java.naming.factory.state",
      "com.sun.corba.ee.impl.presentation.rmi."+
      "JNDIStateFactoryImpl");
    props.setProperty("org.omg.CORBA.ORBInitialHost", 
      remoteServerHost);
    props.setProperty("org.omg.CORBA.ORBInitialPort", 
      remoteServerPort);

    try {
      InitialContext ic = new InitialContext(props);

      // Use this to see what EJBs are available
      // and how to name them
      //NamingEnumeration<NameClassPair> list = 
      //      ic.list("");
      //while (list.hasMore()) {
      //  System.out.println(list.next().getName());
      //}
	
      // Looking up a remote EJB	 	
      SomeEjbRemote testEJB = (SomeEjbRemote) 
          ic.lookup(
          "book.jakarta8.testEjbServer.SomeEjbRemote");

      // Invoking some EJB method
      System.out.println(testEJB.tellMe());
    }catch(Exception e) {
      e.printStackTrace(System.err);
    }
