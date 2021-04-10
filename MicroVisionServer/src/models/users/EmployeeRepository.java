package models.users;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import models.BaseRepository;

public class EmployeeRepository extends BaseRepository {

    public EmployeeRepository(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }

    public Optional<Employee> save(Employee employee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return Optional.of(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Employee> findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee != null ? Optional.of(employee) : Optional.empty();
    }
    
    public List<Employee> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }
    
    public Employee findByUsername(String username){
        Employee employee;
        try {
             employee = entityManager.createNamedQuery("Employee.findByUsername", Employee.class)
            .setParameter("username", username)
            .getSingleResult();
        }catch(NoResultException ex){
            employee = null;
        }
        return employee;
    }
}
