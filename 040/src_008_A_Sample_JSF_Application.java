  package book.jakarta8.hacc.jsfgui;

  import java.io.Serializable;
  import java.time.LocalDate;

  import javax.enterprise.context.SessionScoped;
  import javax.inject.Named;

  @Named
  @SessionScoped
  public class Accounting implements Serializable {
    private static final long serialVersionUID = 
       -1110733631123456L;

    private LocalDate date;
    private String name;

    public String register() {
      return null;
    }

    public LocalDate getDate() {
      return date;
    }

    public void setDate(LocalDate date) {
      this.date = date;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
