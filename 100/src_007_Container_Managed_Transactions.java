...
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.*;

@Singleton
public class MemberDAO {
    ...

    @TransactionAttribute(REQUIRED)
    public List<Member> allMembers() {	
      ...
    }

    @TransactionAttribute(NEVER)
    public Member getMember(int id) {
      ...
    }
	
    ...
}
