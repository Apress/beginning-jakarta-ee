...
import java.util.logging.Logger;

public class MyClass {
  private final static Logger LOG = 
        Logger.getLogger(MyClass.class.toString());

  public void someMethod() {
    LOG.entering(this.getClass().toString(),"someMethod");
    ...
    // different logging levels:
    LOG.finest("Finest: ...");
    LOG.finer("Finer: ...");
    LOG.fine("Fine: ...");
    LOG.info("Some info: ...");
    LOG.warning("Some warning: ...");
    LOG.severe("Severe: ...");
    ...
    LOG.exiting(this.getClass().toString(),"someMethod");    
  }
  ...
}
