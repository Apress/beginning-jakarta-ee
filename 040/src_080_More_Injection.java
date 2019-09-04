
@Named
@SessionScoped
public class Accounting implements Serializable {
    ...
    @PostConstruct public void constr() {
        ...
    }
    @PreDestroy public void destr() {
        ...
    }
}
