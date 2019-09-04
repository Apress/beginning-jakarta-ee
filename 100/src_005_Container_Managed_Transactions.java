@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MemberDAO {
    @Resource private SessionContext ejbContext;
    ...
}
