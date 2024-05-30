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

    @OneToMany(mappedBy = "team") // 연관관계주인이 아님
    private List<Member2> members = new ArrayList<>();

    public Team() {
    }

    public void addMember(Member2 member2) {
        // 양방향 세팅 편의 메소드
        // 한쪽에 넣을것 아니면 무한루프에 빠질수도있음
        member2.setTeam(this);
        members.add(member2);
    }

    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
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