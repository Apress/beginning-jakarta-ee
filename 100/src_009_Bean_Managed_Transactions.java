@Singleton  // or @Stateful / @Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class SomeEjb {
    @Resource UserTransaction transa;
    ...
}
