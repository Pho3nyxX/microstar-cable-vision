package models.users;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ContactNumberRepository {

    private EntityManager entityManager;
    public ContactNumberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<ContactNumber> save(ContactNumber contactNumber) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contactNumber);
            entityManager.getTransaction().commit();
            return Optional.of(contactNumber);
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }
}
