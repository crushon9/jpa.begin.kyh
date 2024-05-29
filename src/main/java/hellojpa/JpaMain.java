package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

// cd ../../h2/bin 경로에서 ./h2.bat 실행 후 서버 올리기
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {
            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);
            //회원 저장
            Member2 m1 = new Member2();
            m1.setName("user1");
            m1.addTeam(team);
            em.persist(m1);

            Member2 m2 = new Member2();
            m2.setName("user2");
            m2.addTeam(team);
            em.persist(m2);

           // em.flush();
            //em.clear();

            Member2 findM2 = em.find(Member2.class, m1.getId());
            Team findT = findM2.getTeam();

            Team findT2 = em.find(Team.class,team.getId());
            List<Member2> findM2List = findT2.getMember2();

            for (Member2 m : findM2List) {
                System.out.println(m.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
