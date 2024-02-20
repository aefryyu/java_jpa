package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Credential;
import masayuki.jpa.entity.User;
import masayuki.jpa.entity.Wallet;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnetoOneTest {

    @Test
    void name() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Credential credential1 = new Credential();
        credential1.setId("masayuki");
        credential1.setEmail("masayuki@yahoo.com");
        credential1.setPassword("0008000");
        entityManager.persist(credential1);

        User user1 = new User();
        user1.setId("masayuki");
        user1.setName("rudra");
        entityManager.persist(user1);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void equals() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "yoru");
        Assertions.assertNotNull(user.getCredential());

        Assertions.assertEquals("windwalker@yahoo.com", user.getCredential().getEmail());
        Assertions.assertEquals("0009000", user.getCredential().getPassword());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void joinColumn() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "yoru");

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(10_000_000L);
        entityManager.persist(wallet);

        entityTransaction.commit();
        entityManager.close();
    }
}
