package hellojpa;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    public List<Member2> getMember2() {
        return member2;
    }

    public void setMember2(List<Member2> member2) {
        this.member2 = member2;
    }

    @OneToMany(mappedBy = "team") // 연관관계주인이 아님
    List<Member2> member2 = new ArrayList<Member2>();

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}