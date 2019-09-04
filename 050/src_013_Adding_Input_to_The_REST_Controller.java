package book.jakarta8.restdate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 */
@Path("/")
public class RestDate {
  @GET
  @Path("date") 
  @Produces("application/json")
  public Response date(
      @QueryParam("dateFormat") @DefaultValue("") 
      String dateFormat) {
    ZonedDateTime zdt = ZonedDateTime.now();
    String outStr = "";
    String errMsg = "";
    try {
      outStr = ("".equals(dateFormat) ? 
          zdt.toString() : 
          zdt.format(DateTimeFormatter.
                     ofPattern(dateFormat)));
      errMsg = "";
    } catch(Exception e) {
      errMsg = e.getMessage();
    }
    return Response.ok().entity(
      "{" +
        "\"date\":\"" + outStr + "\"," + 
        "\"errMsg\":\"" + errMsg + "\"" +
      "}" 
    ).build();
  }
}
