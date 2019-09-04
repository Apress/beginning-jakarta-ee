@Named
@SessionScoped
public class SomeClass implements Serializable {
  private static final long serialVersionUID = -1110734999167266L;

  private boolean check = true;
  private List<String> checks1 = new ArrayList<>();
  private Map<String,String> smcbItems = new HashMap<>();
  // ... getters and setters for these ...

  public SomeClass() {
    smcbItems.put("Label1", "v1");
    smcbItems.put("Label2", "v2");
    smcbItems.put("Label3", "v3");
    smcbItems.put("Label4", "v4");
    smcbItems.put("Label5", "v5");
  }
}
