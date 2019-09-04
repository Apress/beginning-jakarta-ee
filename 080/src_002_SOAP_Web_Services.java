package book.jakarta8.wsdate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WsDate {
  @WebMethod
  public String date(String dateFormat) {
    ZonedDateTime zdt = ZonedDateTime.now();
    String outStr = "";
    String errMsg = "";
    try {
      outStr = ("".equals(dateFormat) ? 
        zdt.toString() : 
        zdt.format(
            DateTimeFormatter.ofPattern(dateFormat)));
      errMsg = "";
    } catch(Exception e) {
      errMsg = e.getMessage();
    }
    // errMsg currently ignored
    return outStr;
  }
}
