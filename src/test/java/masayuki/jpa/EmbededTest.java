package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Departements;
import masayuki.jpa.entity.DepartementsId;
import masayuki.jpa.entity.Member;
import masayuki.jpa.entity.Name;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

public class EmbededTest {

    @Test
    void embeded() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTittle("Dragon Slayer");
        name.setFirstName("wind");
        name.setMiddleName(null);
        name.setLastName("walker");

        Member member = new Member();
        member.setEmail("archer@yahoo.com");
        member.setName(name);

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void embededId() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        DepartementsId id = new DepartementsId();
        id.setDepartemenstId("Valve");
        id.setCompanyId("Dota2");

        Departements departements = new Departements();
        departements.setId(id);
        departements.setName("steam");

        entityManager.persist(departements);

        entityTransaction.commit();
        entityManager.close();
    }
}
