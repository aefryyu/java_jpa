package masayuki.jpa;

import jakarta.persistence.EntityManagerFactory;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntytyManagerFactoryTest {

    @Test
    void create() {
        EntityManagerFactory entytyManagerFactory = JpaUtil.getEntityManagerFactory();
        Assertions.assertNotNull(entytyManagerFactory);
    }
}
