package driver;

import utilities.communication.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import models.users._User;
import models.accounts.*;
import models.users.*;
import models.complaints.*;

public class Driver {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Microstarcablevision");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Create our entity manager
        entityManagerFactory = Persistence.createEntityManagerFactory("Microstarcablevision");
        entityManager = entityManagerFactory.createEntityManager();
        
        // Create our repositories
        // ComplaintRepository complaintRepository = new ComplaintRepository(entityManager);      
        // ResponseRepository responseRepository = new ResponseRepository(entityManager);      

        // // Create a complaint
        // Complaint complaint = new Complaint(0, "Open", "Red dlight on box", "connection", LocalDateTime.now(), 1);
        
        // complaintRepository.save(complaint);
        // Response response = new Response(0, "Return router", LocalDate.now());
        // complaint.addResponse( response );
        // responseRepository.save(response);
        /*
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
        // Customer customer2 = customerRepository.findByUsername("abi5");
        System.out.println(customer);
        // System.out.println(customer.getPhone());
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
        Server server = new Server();

    }
}
