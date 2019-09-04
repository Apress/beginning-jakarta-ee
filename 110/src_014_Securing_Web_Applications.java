package book.jakarta8.julianguisecure;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Function;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@SessionScoped
public class Julian implements Serializable {
  private static final long serialVersionUID = 
    -1110733631543471209L;

  private Date dateIn; // + getter / setter
  private String jd; // + getter / setter

  public String convert() {
    jd = convert(getGd());
    return "/response.xhtml";
  }

  public String getGd() {
    LocalDateTime ldt = LocalDateTime.ofInstant(
        dateIn.toInstant(), ZoneId.of("UTC"));
    return ldt.format(DateTimeFormatter.
        ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  private String convert(String inDate) {
    Function<Double, Integer> trunc = (d) -> d.intValue();

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

    double jd = 367 * inYear - 
        trunc.apply(7.0 * (inYear + 
            trunc.apply((inMonth + 9.0) / 12)) / 4)
	+ trunc.apply(275.0 * inMonth / 9) 
        + inDay + 1721013.5 + 1.0 * 
            (inHour + inMinute / 60.0) / 24
	- 0.5 * Math.signum(100 * inYear 
            + inMonth - 190002.5) + 0.5;

    return "" + jd;
  }
}
