package models.users;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class UserSessionRepository extends BaseRepository {
    
    public UserSessionRepository(EntityManager entityManager) {
        super(entityManager);
    }
        
    public Optional<UserSession> save(UserSession userSession) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userSession);
            entityManager.getTransaction().commit();
            return Optional.of(userSession);
        } catch (Exception e) {
            this.handleSaveError(e);
        }
        return Optional.empty();
    }

    public Optional<UserSession> findById(Integer id) {
        UserSession userSession = entityManager.find(UserSession.class, id);
        return userSession != null ? Optional.of(userSession) : Optional.empty();
    }

    public List<UserSession> findAll() {
        return entityManager.createQuery("from userSession").getResultList();
    }


}
