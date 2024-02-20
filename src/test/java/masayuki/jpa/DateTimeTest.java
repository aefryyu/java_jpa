package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Catagory;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTimeTest {

    @Test
    void timeStamp() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Catagory catagory = new Catagory();
        catagory.setName("Nugget");
        catagory.setDescription("Makanana siap saji");
        catagory.setCreatedAt(Calendar.getInstance());
        catagory.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(catagory);

        entityTransaction.commit();
        entityManager.close();
    }
}
