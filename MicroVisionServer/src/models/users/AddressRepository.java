package models.users;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AddressRepository {

    private EntityManager entityManager;
    public AddressRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Optional<Address> save(Address address) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            return Optional.of(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
