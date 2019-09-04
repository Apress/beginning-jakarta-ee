ByteArrayInputStream bis = 
      new ByteArrayInputStream(xml.getBytes());
InputSource is = 
      new InputSource(bis);
SAXParserFactory factory = 
      SAXParserFactory.newInstance();
SAXParser saxParser = factory.newSAXParser();
UserHandler userhandler = new UserHandler();
saxParser.parse(is, userhandler);     
