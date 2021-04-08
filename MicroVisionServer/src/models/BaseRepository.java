package models;

import javax.persistence.EntityManager;

public class BaseRepository {
    protected EntityManager entityManager;
    public BaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
