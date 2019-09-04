import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;

@Singleton // Example only, all EJB types work!
public class SomeEjb {
  @Asynchronous
  public Future<String> tellMeLater() {

    // Simulate some long running calculation
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }

    return new AsyncResult<String>(
        "Hi from tellMeLater()");
  }
}
