package driver;

import utilities.communication.*;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Microstarcablevision");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
/*        
        // Create our repositories
        CustomerRepository customerRepository = new CustomerRepository(entityManager);

        // Create an customer
        Customer customer = new Customer(1, "abi", "gordon", "middleName", "P@ssword123", 10, "F", "email@server.com", new Address());
        customerRepository.save(customer);

        AddressRepository addressRepository = new AddressRepository(entityManager);
        
        // Create an address
        Address address = new Address(1, "Street", "city", "Country", 1);
        addressRepository.save(address);
        
        ContactNumberRepository contactNumberRepository = new ContactNumberRepository(entityManager);
        
        // Create an address
        ContactNumber contactNumber = new ContactNumber("1876564736", 1);
        contactNumberRepository.save(contactNumber);
        
        
        MessageRepository messageRepository = new MessageRepository(entityManager);
        
        // Create an address
        Message message = new Message(1, "text", true, LocalDateTime.now(), 1, 1, 1);
        messageRepository.save(message);
        */
        Server server = new Server();

    }
}
