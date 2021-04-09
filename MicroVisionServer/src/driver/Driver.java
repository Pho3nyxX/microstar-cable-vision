package driver;

import utilities.communication.*;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import models.users._User;
import models.users.Customer;
import models.accounts.Account;
import models.users.Address;
import models.users.AddressRepository;
import models.users.ContactNumber;
import models.users.CustomerRepository;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Microstarcablevision");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Create our repositories
        CustomerRepository customerRepository = new CustomerRepository(entityManager);
        
        // Create an customer
        Customer customer = new Customer(0, "abi5", "abi", "gordon", "middleName", "P@ssword123", 10, "F", "email2@server.com", new Address("parish", "town","street"));
        ContactNumber cn = new ContactNumber();
        customer.addAccount(new Account("Active",0,customer));
        customerRepository.save(customer);
        cn.setContactNum("876-256-2384");
        customer.setPhone(cn);

        customerRepository.save(customer);
        
        // load a customer
        // Customer customer2 = customerRepository.findByUsername("abi5").get();
        System.out.println(customer);
        // System.out.println(customer.getPhone());
        /*
        AddressRepository addressRepository = new AddressRepository(entityManager);

        Address address1 = addressRepository.findById(1).get();
        List<Address> addressList = addressRepository.findAll();
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
        // Server server = new Server();

    }
}
