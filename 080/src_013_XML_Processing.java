ByteArrayInputStream bis = 
      new ByteArrayInputStream(xml.getBytes());
XMLInputFactory factory = 
      XMLInputFactory.newInstance();
XMLStreamReader parser = 
      factory.createXMLStreamReader(bis);
