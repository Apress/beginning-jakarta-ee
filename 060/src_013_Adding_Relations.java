package book.jakarta8.calypsojpa.jpa;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="STATUS")
@SequenceGenerator(name="STATUS_SEQ", 
                   initialValue=1, allocationSize = 50)
public class Status implements Comparable<Status> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator="STATUS_SEQ")	
    
    @Column(name = "ID")
    private int id;
	
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;	

    @NotNull
    @Column(name = "NAME")
    private String name;

    public Status() {
    }
	
    public Status(String name) {
      this.name = name;
    }	

    @Override
    public int compareTo(Status o) {
      return -o.name.compareTo(name);
    }

    // + getters and setters
}
