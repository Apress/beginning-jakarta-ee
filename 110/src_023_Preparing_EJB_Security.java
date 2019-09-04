package book.jakarta8.juliansecureejb.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import book.jakarta8.juliansecureejb.ejb.interfaces.
      NameEjbLocal;
import book.jakarta8.juliansecureejb.ejb.interfaces.
      NameEjbRemote;

@Singleton 
@Local(NameEjbLocal.class)
@Remote(NameEjbRemote.class)
public class NameEjb 
        implements NameEjbLocal, NameEjbRemote {
    public String hello(String name) {
        return "Hello " + name + " (admin)";
    }
}
