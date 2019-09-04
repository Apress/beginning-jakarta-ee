@Named @SessionScoped
public class SomeClass implements Serializable {
  public static class Datum implements Serializable {
    private String lastName;
    private String firstName;
    public Datum(String ln, String fn) {
      this.lastName = ln;
      this.firstName = fn;
    }
    public String getLastName() {
      return lastName;
    }
    public String getFirstName() {
      return firstName;
    }
  }
  public List<Datum> getData() {
    return Arrays.asList(new Datum("Smith","John"),
        new Datum("Karmikel","Linda"),
        new Datum("Smear","Patrick"));
  }
}
