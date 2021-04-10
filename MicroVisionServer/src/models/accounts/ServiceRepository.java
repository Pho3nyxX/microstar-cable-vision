package models.accounts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public class ServiceRepository {
        
    private EntityManager entityManager;
    
    public ServiceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Optional<Service> save(Service service) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(service);
            entityManager.getTransaction().commit();
            return Optional.of(service);
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<Service> findById(Integer id) {
        Service service = entityManager.find(Service.class, id);
        return service != null ? Optional.of(service) : Optional.empty();
    }

    public List<Service> findAll() {
        return entityManager.createQuery("from Service").getResultList();
    }
}
