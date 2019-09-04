@Named
@SessionScoped
public class TheClass implements Serializable {
    public static class Itm {
        ...
        public String getLab() { return ... }
        public String getVal() { return ... }
    }
    ...
    public List<Itm> getItems() {
       return ...
    }
}
