package book.jakarta8.testEjbServer;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless()
@Remote(SomeEjbRemote.class)
public class SomeEjb implements SomeEjbRemote {
  @Override
  public String tellMe() {
    return "Hello World";
  }
}
