package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Customer;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

public class ColumnTest {

    @Test
    void column() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("001");
        customer.setName("misaki");
        customer.setPrimaryEmail("misaki@yahoo.com");

        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}
