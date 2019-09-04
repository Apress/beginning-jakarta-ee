@Singleton
public class MemberDAO {
    @PersistenceContext
    private EntityManager em;
	
    public List<Member> allMembers() {	
      [ return list of all memebers from the DB ]
    }

    public Member getMember(int id) {
      [ return one member from the DB ]
    }
	
    public int newMember(String lastName, 
          String firstName, String birthday) {
      Member m = new Member();
      [ set member properties ]
      em.persist(m);
      em.flush(); // needed to get the ID
      return m.getId();
    }
	
    public void updateMember(String lastName, 
          String firstName, String birthday, int id) {
      Member m = em.find(Member.class, id);
      [ set member properties ]
      em.persist(m);
    }
	
    public void deleteMember(int id) {
      [ delete member from the DB ]
    }
}
