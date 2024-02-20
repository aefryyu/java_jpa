package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Customer;
import masayuki.jpa.entity.Member;
import masayuki.jpa.entity.Name;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CollectionTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTittle("lion sins");
        name.setFirstName("escanor");
        name.setMiddleName("");
        name.setLastName("");

        Member member = new Member();
        member.setName(name);
        member.setEmail("escanor@yahoo.com");
        member.setId(100);

        member.setHobbies(new ArrayList<>());
        member.getHobbies().add("cooking");
        member.getHobbies().add("fighting");

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void createMap() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTittle("lion sins");
        name.setFirstName("escanor");
        name.setMiddleName("");
        name.setLastName("");

        Member member = new Member();
        member.setName(name);
        member.setEmail("escanor@yahoo.com");
        member.setId(100);

        member.setHobbies(new ArrayList<>());
        member.getHobbies().add("cooking");
        member.getHobbies().add("fighting");

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }
}
