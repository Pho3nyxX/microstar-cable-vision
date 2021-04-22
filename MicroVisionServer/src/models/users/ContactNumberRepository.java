package models.users;

import javax.persistence.EntityManager;

import models.BaseRepository;

import java.util.List;
import java.util.Optional;

public class ContactNumberRepository extends BaseRepository {

    public ContactNumberRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<ContactNumber> save(ContactNumber contactNumber) {
        try {
            entityManager.getTransaction().begin();
            
            entityManager.persist(contactNumber);
            
            entityManager.getTransaction().commit();
            
            return Optional.of(contactNumber);
        
        } catch (Exception e) {
            
            this.handleSaveError(e);
        }
        return Optional.empty();
    }

    public Optional<ContactNumber> findById(Integer id) {
        ContactNumber contactNumber = entityManager.find(ContactNumber.class, id);
        return contactNumber != null ? Optional.of(contactNumber) : Optional.empty();
    }

    public List<ContactNumber> findAll() {
        return entityManager.createQuery("from ContactNumber").getResultList();
    }
}
