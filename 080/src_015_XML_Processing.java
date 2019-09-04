import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class UserHandler extends DefaultHandler {
   @Override
   public void startElement(
       String uri, String localName, String qName, 
       Attributes attributes)
       throws SAXException {
			   
     String attrs = "[";
     for(int i=0; i < attributes.getLength();i++) {
       attrs += attributes.getLocalName(i) + "=" + 
             attributes.getValue(i)+ ",";
     }
     attrs = attrs.length() > 1 ? 
           attrs.substring(0, attrs.length()-1) : attrs;
     attrs += "]";
			   
     System.err.println("-> " + localName + " - " + 
           uri + " - " + qName + " - " + attrs);
   }

   @Override
   public void endElement(String uri, 
       String localName, String qName) 
       throws SAXException {
     System.err.println("<- " + localName + " - " + 
           uri + " - " + qName);
   }

   @Override
   public void characters(char ch[], int start, 
         int length) throws SAXException {
     String chars = new String(ch, start, length);
     if(!chars.trim().isEmpty())
       System.err.println("CHARS: " + chars);
   }
}
