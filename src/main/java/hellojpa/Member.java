package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name="aaa") // JPA에서 사용할 엔티티 이름
@Table(name="member") // 매핑할 테이블이름
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1) // allocationSize 기본값 50이므로 반드시 1로 설정해야함
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", updatable = false, nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum 타입 매핑 : EnumType.STRING 이름을 데이터베이스에 저장
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입 매핑
    private Date lastModifiedDate;
    private LocalDate createdDate; // 자바8 이상부터는 타입에서 바로 매핑가능

    @Lob // BLOB, CLOB 매핑
    private String description;

    @Transient // 컬럼에 매핑하지 않음 : 메모리상에서만 임시로 사용할 때
    private Integer temp;

    public Member() { // 기본생성자
    }
}