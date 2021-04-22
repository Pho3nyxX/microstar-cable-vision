package models.complaints;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class VisitRepository extends BaseRepository{

    public VisitRepository(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }

    public Optional<Visit> save(Visit visit) {
        try {
            
            entityManager.getTransaction().begin();
            
            entityManager.persist(visit);
            
            entityManager.getTransaction().commit();
            
            return Optional.of(visit);

        } catch (Exception e) {
            
            this.handleSaveError(e);
        
        }
        
        return Optional.empty();
    }

    public Optional<Visit> findById(Integer id) {
        Visit visit = entityManager.find(Visit.class, id);
        return visit != null ? Optional.of(visit) : Optional.empty();
    }
    
    public List<Visit> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }
    
}
