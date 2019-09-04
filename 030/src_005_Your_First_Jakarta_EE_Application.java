package book.jakarta8.julian;

import java.util.function.Function;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 */
@Path("/")
public class Julian {
    @GET
    @Produces("text/plain")
    @Path("convert/{inDate : .*}")
    public String convert(
          @PathParam("inDate") String inDate) {

        Function<Double,Integer> trunc = (d) -> 
            d.intValue();

        // yyyy-MM-dd-HH-mm-ss
        int inYear = Integer.parseInt(
          inDate.substring(0, 4));
        int inMonth = Integer.parseInt(
          inDate.substring(5, 7));
        int inDay = Integer.parseInt(
          inDate.substring(8, 10));
        int inHour = Integer.parseInt(
          inDate.substring(11, 13));
        int inMinute = Integer.parseInt(
          inDate.substring(14, 16));
	
        double jd = 367 * inYear
          - trunc.apply(  7.0 * ( 
              inYear + trunc.apply((inMonth+9.0)/12)  
                                ) / 4   )
          + trunc.apply(275.0 * inMonth / 9)
          + inDay
          + 1721013.5
          + 1.0 * (inHour + inMinute / 60.0) / 24
          - 0.5*Math.signum(100*inYear + inMonth -190002.5)
          + 0.5;
	    	
        return "" + jd;
    }
}
