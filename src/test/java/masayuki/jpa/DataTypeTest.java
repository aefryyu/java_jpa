package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Customer;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

public class DataTypeTest {

    @Test
    void DataType() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("A");
        customer.setName("jue viole");
        customer.setPrimaryEmail("grace@yahoo.com");
        customer.setAge((byte)40);
        customer.setCouple(true);
        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}
