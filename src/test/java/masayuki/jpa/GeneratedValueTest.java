package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Catagory;
import masayuki.jpa.entity.Customer;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratedValueTest {

    @Test
    void add() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Catagory catagory = new Catagory();
        catagory.setName("bakwan");
        catagory.setDescription("lauk umum mayarakat");

        entityManager.persist(catagory);
        Assertions.assertNotNull(catagory.getId());

        entityTransaction.commit();
        entityManager.close();
    }
}
