  TransformerFactory transformerFactory = 
        TransformerFactory.newInstance();
  Transformer transformer = transformerFactory.
        newTransformer();
			
  // Remove whitespaces outside tags
  XPathFactory xfact = XPathFactory.newInstance();
  XPath xpath = xfact.newXPath();
  NodeList empty = (NodeList) xpath.
        evaluate(
          "//text()[normalize-space(.) = '']",
          doc, XPathConstants.NODESET);
  for (int i = 0; i < empty.getLength(); i++) {
    Node node = empty.item(i);
    node.getParentNode().removeChild(node);
  }

  // Re-indent
  transformer.setOutputProperty(
        OutputKeys.INDENT, "yes");
  transformer.setOutputProperty(
        "{http://xml.apache.org/xslt}indent-amount", "2");
			
  DOMSource source = new DOMSource(doc);
  StreamResult result = new StreamResult(System.out);
  transformer.transform(source, result);
