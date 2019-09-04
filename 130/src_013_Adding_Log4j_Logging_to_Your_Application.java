import org.apache.logging.log4j.*;

public class SomeClass {
  private final static Logger LOG = 
        LogManager.getLogger(SomeClass.class);
  ...
  public void someMethod() {
    ...
    // different logging levels:
    LOG.trace("Trace: ...");
    LOG.debug("Debug: ...");
    LOG.info("Some info: ...");
    LOG.warn("Some warning: ...");
    LOG.error("Some error: ...");
    LOG.fatal("Some fatal error: ...");
    ...
    // Logging in try-catch clauses
    try {
       ...
    } catch(Exception e) {
       ...
       LOG.error("Some error", e);
    }
  }
}
