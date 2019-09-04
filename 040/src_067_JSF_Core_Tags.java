  import java.io.Serializable;
  import java.time.LocalDate;
  import javax.enterprise.context.SessionScoped;
  import javax.inject.Named;

  @SessionScoped
  @Named
  public class AjaxBean implements Serializable {	  
    private String firstName = ""; // + getter/setter
    private String lastName = "";  // + getter/setter
    private LocalDate birthday;    // + getter/setter
	
    public String submit() {
      System.err.println("submit: " + firstName + 
          " " + lastName);
      return null;
    }

    public String getCombinedName() {
      return firstName + " " + lastName;
    }
}
