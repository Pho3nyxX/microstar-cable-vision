package models.complaints;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class ComplaintRepository extends BaseRepository{

    public ComplaintRepository(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }

    public Optional<Complaint> save(Complaint complaint) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(complaint);
            entityManager.getTransaction().commit();
            return Optional.of(complaint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Complaint> findById(Integer id) {
        Complaint complaint = entityManager.find(Complaint.class, id);
        return complaint != null ? Optional.of(complaint) : Optional.empty();
    }
    
    public List<Complaint> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }
    
}
