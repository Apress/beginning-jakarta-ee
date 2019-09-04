  @Named
  @SessionScoped
  public class Xyz implements Serializable {
    private static final long serialVersionUID = 
       -1110733631123456L;

    private String abc = "Hello";
    private String submit = "Submit";
    private String name;

    public String getName() { return name; }
    public void setName(String name) { 
        this.name = name; }

    public String getAbc() { return abc; }
    public void setAbc(String abc) { 
        this.abc = abc; }

    public String getSubmit() { return submit; }
    public void setSubmit(String submit) { 
        this.submit = submit; }

    public String go() {
      ...
      return null;
    }
  }
