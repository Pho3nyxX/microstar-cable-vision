package models.accounts;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import models.BaseRepository;

public class PaymentRepository extends BaseRepository{
        

    public Optional<Payment> save(Payment payment) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(payment);
            entityManager.getTransaction().commit();
            return Optional.of(payment);
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<Payment> findById(Integer id) {
        Payment payment = entityManager.find(Payment.class, id);
        return payment != null ? Optional.of(payment) : Optional.empty();
    }

    public List<Payment> findAll() {
        return entityManager.createQuery("from Payment").getResultList();
    }

    /**---------------------------CONSTRUCTERS------------------------------------ */
    public PaymentRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
