  Node root = doc.getDocumentElement();
		
  // Getting a node name
  System.err.println("Name = " + root.getNodeName()); 
  // -> recordings
			
  // Iterate through child elements
  DOMIterator.stream(root).
        filter(n -> n.getNodeType() == Node.ELEMENT_NODE).
        forEach(n -> {
    System.err.println("Child Name = " + n.getNodeName()); 
    // -> recording, recording, ...
  });
	 		
  // Navigating and finding
  Node third = DOMIterator.stream(root).
        filter(n -> n.getNodeType() == Node.ELEMENT_NODE).
        skip(2).findFirst().get();
  String thrdComposer = DOMIterator.stream(third).
        filter(n -> n.getNodeName().equals("composer")).
        findFirst().get().getTextContent();  
  String thrdGenre = third.getAttributes().
        getNamedItem("genre").getNodeValue();
  System.err.println("3rd Composer = " + thrdComposer);
  System.err.println("3rd Genre = " + thrdGenre);
			
  // Changing and adding an attribute
  third.getAttributes().getNamedItem("genre").
        setNodeValue("ROCK");
  Attr attr = doc.createAttribute("classification");
  attr.setNodeValue("kx-7");
  third.getAttributes().setNamedItem(attr);
			
  // Adding a node
  Node newNode = doc.createElement("country");
  newNode.setTextContent("Ireland");
  third.appendChild(newNode);
