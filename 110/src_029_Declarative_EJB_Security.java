import javax.annotation.security.*;
...

@DeclareRoles({"rx1", "rx2", "ry1", "ry2", ...})
// restricting access to the whole EJB:
@RolesAllowed({"rx1", "rx2", ...})
... more annotations ...
public class SomeEjb implements ... {
    // restricting access to some method
    @RolesAllowed({"ry1", "ry2", ...})
    public void someMethod() {
        ...
    }
    ...
}
