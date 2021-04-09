package models.users;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager entityManager;
    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Optional<Customer> save(Customer customer) {
        _Customer cust = new _Customer(customer);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cust);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
