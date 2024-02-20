package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Brands;
import masayuki.jpa.entity.Product;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

public class OneToManyTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Brands brands = new Brands();
        brands.setId("CP-0");
        brands.setName("CP-zero");
        entityManager.persist(brands);

        Product product1 = new Product();
        product1.setId("0001");
        product1.setName("ketupat");
        product1.setBrands(brands);
        product1.setPrice(1_000L);
        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setId("0002");
        product2.setName("tahu");
        product2.setBrands(brands);
        product2.setPrice(1_500L);
        entityManager.persist(product2);

        entityTransaction.commit();
        entityManager.close();
    }
}
