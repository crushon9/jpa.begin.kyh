package hellojpa;
import javax.persistence.*;

@Entity
public class Member2 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @ManyToOne // 연관관계 매핑
    @JoinColumn(name = "TEAM_ID") // 연관관계주인
    private Team team;

    public Member2() {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addTeam(Team team) {
        this.team = team;
        team.getMember2().add(this); // this : member2
    }
}