public class SomeEjb implements ... {
    @EJB private SomeOtherEjb ejb2;
    ...

    @RunAs("member")
    public void someMethod() {
        ejb2.doSomething();
    }
    ...
}
