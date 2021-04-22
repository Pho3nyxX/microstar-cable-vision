package models.accounts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import models.BaseRepository;

public class AccountRepository extends BaseRepository {

    public AccountRepository(EntityManager entityManager) {

        super(entityManager);
        // TODO Auto-generated constructor stub
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

    /**
     * 
     * @param id
     * @return
     */
    public Account findById(Integer id) {

        Account account;

        try {

            account = entityManager.find(Account.class, id);

        } catch (Exception ex) {

            account = null;
            
        }

        return account;
    }

    /**
     * 
     * @return
     */
    public List<Account> findAll() {

        return entityManager.createQuery("from Account").getResultList();
    }

    /**
     * 
     * @param customer_id
     * @return
     */
    public Account findByCustomerId(int customer_id) {

        Account account;

        try {

            account = entityManager.createNamedQuery("Account.findByCustomerId", Account.class)
                    .setParameter("customer_id", customer_id).getSingleResult();

        } catch (NoResultException ex) {
            account = null;
        }
        return account;
    }
}
