package models.complaints;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class ResponseRepository extends BaseRepository{

    public ResponseRepository(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }
    
    public Optional<Response> save(Response response) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(response);
            entityManager.getTransaction().commit();
            return Optional.of(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Response> findById(Integer id) {
        Response response = entityManager.find(Response.class, id);
        return response != null ? Optional.of(response) : Optional.empty();
    }
    
    public List<Response> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }
}
