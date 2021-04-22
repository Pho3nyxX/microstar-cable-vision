package models;

import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseRepository {
    protected Logger connection = LogManager.getLogger("Connection");
    protected Logger error = LogManager.getLogger("Error");

    protected EntityManager entityManager;

    public BaseRepository(EntityManager entityManager) {
        
        this.entityManager = entityManager;
    }

    protected void handleSaveError(Exception ex){
        entityManager.getTransaction().rollback();
        
        error.error(ex.getMessage());
        
        ex.printStackTrace();
    }
}
