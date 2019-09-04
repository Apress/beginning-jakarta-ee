// show all elements
StaxIterator.stream(parser).
    filter(elem -> elem.isStartElement()).
    forEach(sr -> {
        System.err.println(sr.getLocalName());
});
			
// show all composers
bis.reset();
XMLStreamReader parser2 = 
      factory.createXMLStreamReader(bis);
System.err.println(
  StaxIterator.stream(parser2).
  filter(elem -> elem.isStartElement()).
  filter(elem -> elem.getLocalName().equals("composer")).
  map(StaxIterator::getElementText).
  distinct().
  collect(Collectors.joining(","))
);
			
// count records
bis.reset();
XMLStreamReader parser3 = 
      factory.createXMLStreamReader(bis);
long recNum = StaxIterator.stream(parser3).
  filter(elem -> elem.isStartElement()).
  filter(elem -> elem.getLocalName().equals("recording")).
  count();
System.err.println(recNum);
