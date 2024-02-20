package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Customer;
import masayuki.jpa.entity.CustomerType;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void CustomerEnum() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("O");
        customer.setName("varoy");
        customer.setPrimaryEmail("gui@gmail.com");
        customer.setAge((byte)78);
        customer.setCouple(false);
        customer.setType(CustomerType.VIP);
        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}
