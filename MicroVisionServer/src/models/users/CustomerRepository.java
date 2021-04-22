package models.users;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import models.BaseRepository;

import java.util.List;
import java.util.Optional;

public class CustomerRepository extends BaseRepository{

    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Optional<Customer> save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            
            entityManager.persist(customer);
            
            entityManager.getTransaction().commit();
            
            return Optional.of(customer);
        
        } catch (Exception e) {
            
            this.handleSaveError(e);
        }
        return Optional.empty();
    }

    public Customer findById(Integer id) {
        Customer customer;
        try{
            customer = entityManager.find(Customer.class, id);
        }catch(Exception ex){
            customer = null;
        }
        return customer;
    }
    
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }
    
    public Customer findByUsername(String username){
        Customer customer;
        try {
            customer = entityManager.createNamedQuery("Customer.findByUsername", Customer.class)
            .setParameter("username", username)
            .getSingleResult();
        }catch(NoResultException ex){
            customer = null;
        }
        return customer;
    }
}
