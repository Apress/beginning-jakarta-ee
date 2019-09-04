package book.jakarta8.juliangui;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * A CDI managed bean.
 */
@Named
@SessionScoped
public class Julian implements Serializable {
  private static final long serialVersionUID = 
      -1110733631543658209L;
   
  private Date dateIn;
  private String jd;

  public String convert() {		
    try {
      Client client = ClientBuilder.newClient();
      String gdStr = getGd().replace(" ", "-").
          replace(":", "-");
      String q = 
          "http://localhost:8080/julian/webapi/convert/" + 
          gdStr;
      WebTarget target = client.target(q);
      jd = target.request().get(String.class);
    } catch (Exception e) {
      FacesContext.getCurrentInstance().
          addMessage("myform:getdate", 
          new FacesMessage("Exception " + e,
              "Exception " + e));
      jd = "0.0";
      return null;
    } 
    return "/response.xhtml";
  }	
	
  public Date getDateIn() {
    return dateIn;
  }

  public void setDateIn(Date dateIn) {
    this.dateIn = dateIn;
  }
	
  public String getGd() {
    LocalDateTime ldt = LocalDateTime.ofInstant(
        dateIn.toInstant(), ZoneId.of("UTC"));
    return ldt.format(DateTimeFormatter.ofPattern(
        "yyyy-MM-dd HH:mm:ss"));
  }

  public String getJd() {
    return jd;
  }
}
