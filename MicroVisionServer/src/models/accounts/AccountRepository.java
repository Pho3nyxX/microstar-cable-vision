package models.accounts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class AccountRepository extends BaseRepository{
    

    public AccountRepository(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }

    public Optional<Account> save(Account account) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
            return Optional.of(account);
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<Account> findById(Integer id) {
        Account account = entityManager.find(Account.class, id);
        return account != null ? Optional.of(account) : Optional.empty();
    }

    public List<Account> findAll() {
        return entityManager.createQuery("from Account").getResultList();
    }
}
