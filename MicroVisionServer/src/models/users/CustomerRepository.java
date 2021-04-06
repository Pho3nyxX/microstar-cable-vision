package models.users;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager entityManager;
    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Optional<_User> save(_User customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
