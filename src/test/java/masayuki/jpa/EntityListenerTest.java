package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Catagory;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

public class EntityListenerTest {

    @Test
    void listener() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Catagory catagory = new Catagory();
        catagory.setName("testListener");

        entityManager.persist(catagory);

        entityTransaction.commit();
        entityManager.close();
    }
}
