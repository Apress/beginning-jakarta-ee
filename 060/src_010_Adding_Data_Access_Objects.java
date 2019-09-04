package book.jakarta8.calypsojpa.ejb;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import book.jakarta8.calypsojpa.jpa.Member;

@Singleton
public class MemberDAO {
    @PersistenceContext
    private EntityManager em;
	
    public List<Member> allMembers() {	
      TypedQuery<Member> q = em.createQuery(
          "SELECT m FROM Member m", Member.class);
      List<Member> l = q.getResultList();
      return l;
    }

    public Member getMember(int id) {
      return em.find(Member.class, id);
    }
	
    public int newMember(String lastName, 
          String firstName, String birthday) {
      Member m = new Member();
      m.setFirstName(firstName);
      m.setLastName(lastName);
      m.setBirthday(birthday);
      em.persist(m);
      em.flush(); // needed to get the ID
      return m.getId();
    }
	
    public void updateMember(String lastName, 
          String firstName, String birthday, int id) {
      Member m = em.find(Member.class, id);
      m.setLastName(lastName);
      m.setFirstName(firstName);
      m.setBirthday(birthday);
      em.persist(m);
    }
	
    public void deleteMember(int id) {
      Member m = em.find(Member.class, id);
      em.remove(m);
    }
}
