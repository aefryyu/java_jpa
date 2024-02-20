package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Customer;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Crud {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("AABC");
        customer.setName("Mzino");

        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void find() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "AAB");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("AAB", customer.getId());
        Assertions.assertEquals("Enryuu", customer.getName());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void update() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "AABC");
        customer.setName("Urek Mazino");
        entityManager.merge(customer);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void delete(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "AABC");
        entityManager.remove(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}
