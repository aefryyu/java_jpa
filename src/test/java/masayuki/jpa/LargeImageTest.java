package masayuki.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import masayuki.jpa.entity.Image;
import masayuki.jpa.util.JpaUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class LargeImageTest {

    @Test
    void image() throws IOException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Image image = new Image();
        image.setName("hatsune miku");
        image.setDescription("vocaloid otaku center");

        byte[] bytes;
        bytes = Files.readAllBytes(Path.of(getClass()
                .getResource("images/hatsune.png")
                .getPath()));

        image.setImage(bytes);
        entityManager.persist(image);

        entityTransaction.commit();
        entityManager.close();

    }
}
