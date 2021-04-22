package models.users;

import javax.persistence.EntityManager;

import models.BaseRepository;

import java.util.List;
import java.util.Optional;

public class AddressRepository extends BaseRepository{

    public AddressRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Optional<Address> save(Address address) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            return Optional.of(address);
        } catch (Exception e) {
            this.handleSaveError(e);
        }
        return Optional.empty();
    }

    public Optional<Address> findById(Integer id) {
        Address address = entityManager.find(Address.class, id);
        return address != null ? Optional.of(address) : Optional.empty();
    }

    public List<Address> findAll() {
        return entityManager.createQuery("from Address").getResultList();
    }
}
