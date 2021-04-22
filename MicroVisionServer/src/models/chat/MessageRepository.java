package models.chat;

import javax.persistence.EntityManager;
import java.util.Optional;

public class MessageRepository {

    private EntityManager entityManager;

    public MessageRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public Optional<Message> save(Message message) {

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(message);
            entityManager.getTransaction().commit();
            return Optional.of(message);

        } catch (Exception e) {

            System.out.println(e.getClass());
            e.printStackTrace();
        }
        
        return Optional.empty();
    }
}
