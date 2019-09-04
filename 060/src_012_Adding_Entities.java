package book.jakarta8.calypsojpa.jpa;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="MEMBER")
@SequenceGenerator(name="MEMBER_SEQ", 
                   initialValue=1, allocationSize = 50)
public class Member implements Comparable<Member> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator="MEMBER_SEQ")	
    @Column(name = "ID")
    private int id;
	
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;
	
    @NotNull
    @Column(name = "BIRTHDAY", length = 10)
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",
             message="Birthday format: yyyy-MM-dd.")
    private String birthday;

    @Override
    public int compareTo(Member o) {
      if(o.birthday.compareTo(birthday) != 0)
        return o.birthday.compareTo(birthday);
      if(o.lastName.compareTo(lastName) != 0)
        return -o.lastName.compareTo(lastName);
      return -o.firstName.compareTo(firstName);
    }

    // + getters and setters for all properties
}
