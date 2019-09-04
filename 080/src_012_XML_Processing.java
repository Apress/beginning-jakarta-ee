import java.util.stream.Stream;
import com.codepoetics.protonpack.StreamUtils;

public class StaxIterator {
    private XMLStreamReader parser;
    public StaxIterator(XMLStreamReader parser) {
        this.parser = parser;
    }
    public Stream<XMLStreamReader> stream() {
        return StreamUtils.
              takeWhile(Stream.iterate(parser, pa -> {
          try {
            if(!pa.hasNext())
              return null;
            pa.next();
          } catch (XMLStreamException e) {
            e.printStackTrace(System.err);
          }
          return pa;
        }), elem -> elem != null);
    }
    public static Stream<XMLStreamReader> 
          stream(XMLStreamReader n) {
      return new StaxIterator(n).stream();
    }
    public static String getElementText(
          XMLStreamReader n) {
      try {
        return n.getElementText();
      } catch (XMLStreamException e) {
	return "";
      }
    }
}
