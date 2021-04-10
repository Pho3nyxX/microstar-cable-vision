package models.accounts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class BillRepository extends BaseRepository{

    public BillRepository(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }

    public Optional<Bill> save(Bill bill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bill);
            entityManager.getTransaction().commit();
            return Optional.of(bill);
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<Bill> findById(Integer id) {
        Bill bill = entityManager.find(Bill.class, id);
        return bill != null ? Optional.of(bill) : Optional.empty();
    }

    public List<Account> findAll() {
        return entityManager.createQuery("from Bill").getResultList();
    }
}
