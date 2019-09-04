package book.jakarta8.restdate;

import java.time.ZonedDateTime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 */
@Path("/d")
public class RestDate {
  @GET
  @Produces("text/plain")
  public String stdDate() {
    return ZonedDateTime.now().toString();
  } 
}
