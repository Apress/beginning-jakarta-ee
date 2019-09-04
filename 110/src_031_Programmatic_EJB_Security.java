import javax.ejb.SessionContext;
...
public class SomeEjb implements ... {
    @Resource private SessionContext ctx;
    ...

    public void someMethod() {
        if(ctx.isCallerInRole("SomeRole")) {
            ...
        } else { 
            throw new SecurityException(...);
        }
    }
    ...
}
