package utilities.communication;

import driver.Driver;

import models.accounts.Account;
import models.accounts.AccountRepository;
import models.accounts.Bill;
import models.accounts.BillRepository;
import models.accounts.Payment;
import models.accounts.PaymentRepository;
import models.accounts.Service;
import models.accounts.ServiceRepository;
import models.chat._Message;
import models.complaints.Complaint;
import models.complaints.ComplaintRepository;
import utilities.ServerRequest;
import utilities.ServerResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.users._User;
import models.users.Customer;
import models.users.CustomerRepository;
import models.users.Employee;
import models.users.EmployeeRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MultipleClientHandler implements Runnable {

    protected Logger connection = LogManager.getLogger("Connection");
    protected Logger error = LogManager.getLogger("Error");
    protected Socket connectionSocket;
    protected ObjectOutputStream objectOutputStream;
    protected ObjectInputStream objectInputStream;


    public MultipleClientHandler(Socket socketObject) {

        this.connectionSocket = socketObject;
    }


    @Override
    public void run() {

        try {

            ServerRequest serverRequest;
            objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());

            // this.configureStreams();
            // stmt = dBConn.createStatement();
            // result = s.executeQuery("SELECT * FROM user");
            /*
             * if(rs.next()){ System.out.println(rs.getString(2)); }
             */
            connection.warn("Attempting to receive data from client");
            serverRequest = (ServerRequest) objectInputStream.readObject();
            System.out.println("Log user in");
            connection.info("Data successfully received from client");
            // System.out.println(action.getClass());

            System.out.println(serverRequest);

            switch (serverRequest.getCommand()) {

            case ServerRequest.USER_LOGIN_COMMAND -> {

                ServerResponse response = login(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.USER_LOAD_COMMAND -> {

                ServerResponse response = loadUser(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.USER_LOAD_MANY_COMMAND -> {

                ServerResponse response = loadUsers(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.USER_UPDATE_COMMAND -> {

                ServerResponse response = saveUser(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.ACCOUNT_LOAD_COMMAND -> {

                ServerResponse response = loadAccount(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.SERVICE_UPDATE_COMMAND -> {

                ServerResponse response = saveService(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.BILL_UPDATE_COMMAND -> {

                ServerResponse response = saveBill(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.PAYMENT_UPDATE_COMMAND -> {

                ServerResponse response = savePayment(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.COMPLAINT_lOAD_COMMAND -> {

                ServerResponse response = loadComplaint(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.COMPLAINT_lOAD_MANY_COMMAND -> {

                ServerResponse response = loadComplaints(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.COMPLAINT_UPDATE_COMMAND -> {

                ServerResponse response = saveComplaint(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case "User-Register" -> {
                // Actions to register user
            }

            case ServerRequest.USER_LIVE_CHAT_COMMAND -> {

                // Actions to log on live chat
                ServerResponse response = logOnUserToLiveChat(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.USER_END_CHAT_COMMAND -> {

                // Actions to log the user off the live chat
                ServerResponse response = logOffUserFromLiveChat(serverRequest);
                objectOutputStream.writeObject(response);
            }

            case ServerRequest.USER_SEND_MESSAGE_LIVE_CHAT_COMMAND -> {

                _Message message = (_Message) serverRequest.getData();
                // Actions to send message

                // Search for the recipient of the message in the connected clients list

                for (MultipleClientHandler client : Server.activeClients) {

                    // Check if the recipient is an emplotyyee
                    for (_User onlineUser : Server.activeLiveChatUsers) {

                        if (message.getRecipientId() == onlineUser.getUserID()) {

                            // Send message to that employee
                            ServerResponse response;
                            String responseMessage = "Incoming message";
                            int code = ServerResponse.REQUEST_SUCCEEDED;
                            response = new ServerResponse<_Message>(responseMessage, code, message);
                            client.objectOutputStream.writeObject(response);
                            break;
                        }
                    }
                }
            }
            }
            // Save the message to the database
            // Driver.messageRepository.save(message);

        } catch (IOException | ClassNotFoundException ex) {

            error.error(ex.getMessage());
        }
    }

    /**
     * 
     * @param action
     * @return
     */
    ServerResponse loadUser(ServerRequest action) {

        int code = ServerResponse.REQUEST_FAILED;
        String message = "User doesn't exist.";
        ServerResponse response;
        _User user = null;

        // TODO:: Handle user load
        if (action.getData().getClass() == Customer.class) {

            System.out.println("This is a customer");
            Customer customer = null;
            CustomerRepository customerRepository = new CustomerRepository(Driver.entityManager);
            user = (Customer) action.getData();
            // check if user id or username available

            if (user.getUserID() > 0) {

                // load user by id
                customer = customerRepository.findById(user.getUserID());
                customer.getAccounts();

            } else if (!user.getUsername().isBlank() || user.getUsername() == null) {
                // load user by username
                customer = customerRepository.findByUsername(user.getUsername());
            }
            // if(customer != null){
            // set the customer as the user to be return to the client
            user = customer;
            // }
        } else if (action.getData().getClass() == Employee.class) {
            System.out.println("This is a employee");
            user = (Employee) action.getData();

            Employee employee = null;
            EmployeeRepository employeeRepository = new EmployeeRepository(Driver.entityManager);
            user = (Employee) action.getData();
            // check if user id or username available
            if (user.getUserID() > 0) {
                // load user by id
                employee = employeeRepository.findById(user.getUserID());
            } else if (!user.getUsername().isBlank() || user.getUsername() == null) {
                // load user by username
                employee = employeeRepository.findByUsername(user.getUsername());
            }
            // if(customer != null){
            // set the customer as the user to be return to the client
            user = employee;

        }

        if (user != null) {// TODO: check if users found
            message = "User found";
            code = ServerResponse.REQUEST_SUCCEEDED;
        }
        response = new ServerResponse<_User>(message, code, user);
        return response;
    }

    /**
     * 
     * @param action
     * @return
     */
    ServerResponse loadUsers(ServerRequest action) {
        int code = ServerResponse.REQUEST_FAILED;
        String message = "No users found.";
        ServerResponse response = null;

        // TODO: load users
        if (action.getData().getClass() == Customer.class) {
            CustomerRepository customerRepository = new CustomerRepository(Driver.entityManager);
            List<Customer> userList = customerRepository.findAll();
            if (userList.size() > 0) {
                message = "Customers found"; // TODO: add user count to message
                code = ServerResponse.REQUEST_SUCCEEDED;
            }
            response = new ServerResponse<List<Customer>>(message, code, userList);
        } else if (action.getData().getClass() == Employee.class) {
            EmployeeRepository employeeRepository = new EmployeeRepository(Driver.entityManager);
            List<Employee> userList = employeeRepository.findAll();
            if (userList.size() > 0) {
                message = "Employees found"; // TODO: add user count to message
                code = ServerResponse.REQUEST_SUCCEEDED;
            }
            response = new ServerResponse<List<Employee>>(message, code, userList);
        }
        return response;
    }

    /**
     * 
     * @param action
     * @return
     */
    ServerResponse saveUser(ServerRequest action) {

        int code = ServerResponse.SAVE_FAILED;
        String message = "No users found.";
        ServerResponse response = null;
        _User user = null;

        // TODO:: Handle user save
        if (action.getData().getClass() == Customer.class) {

            CustomerRepository customerRepository = new CustomerRepository(Driver.entityManager);
            Customer customer = (Customer) action.getData();
            // customerRepository.save(customer);
            customer.addAccount(new Account(Account.ACCOUNT_UPTODATE, 0, customer));
            customerRepository.save(customer);
            message = "Customer saved";
            user = customer;
            code = ServerResponse.SAVE_SUCCEEDED;
            response = new ServerResponse<Customer>(message, code, customer);

        } else if (action.getData().getClass() == Employee.class) {

            EmployeeRepository employeeRepository = new EmployeeRepository(Driver.entityManager);
            Employee employee = (Employee) action.getData();
            employeeRepository.save(employee);
            message = "Employee saved";
            user = employee;
            code = ServerResponse.SAVE_SUCCEEDED;
        }
        response = new ServerResponse<_User>(message, code, user);
        return response;
    }

    /**
     * 
     * @param serverRequest
     * @return
     */
    ServerResponse login(ServerRequest serverRequest) {

        // Actions for user login
        boolean loggedIn = false;
        int code = ServerResponse.REQUEST_FAILED;
        UUID sessionId = null;
        String message = "Login Failed.";
        ServerResponse response;
        CustomerRepository customerRepository = new CustomerRepository(Driver.entityManager);
        
        _User user = (_User) serverRequest.getData();

        // System.out.println(user.get);

        // System.out.println(action.getData().toString());
        Customer customer = null;
        
        customer = customerRepository.findByUsername(user.getUsername());

        if (customer != null) {

            if (customer.getPassword().equals(user.getPassword())) {

                user = customer;

            } else {

                user = null;
            }

        } else {

            EmployeeRepository employeeRepository = new EmployeeRepository(Driver.entityManager);
            Employee employee = employeeRepository.findByUsername(user.getUsername());
            // user = employee;

            if (employee != null && employee.getPassword().equals(user.getPassword())) {

                user = employee;

            } else {

                user = null;
            }
        }

        // TODO: check database to match credentials, update database - user session

        // send response to client

        if (user != null) {// TODO: test if user data is corrects

            // TODO: generate sessionId
            loggedIn = true;
            sessionId = UUID.randomUUID();
            code = ServerResponse.REQUEST_SUCCEEDED;
            message = sessionId.toString();

        } else {

        }
        response = new ServerResponse<_User>(message, code, user);

        return response;
    }

    /**
     * ---------------------------SERVICES & BILLING--------------------------------
     */

    /**
     * save a Service
     * 
     * @param action
     * @return
     */
    ServerResponse saveService(ServerRequest action) {
        int code = ServerResponse.SAVE_FAILED;
        String message = "Bill not saved.";
        ServerResponse response = null;
        Service service = null;

        // TODO:: Handle user save
        if (action.getData().getClass() == Service.class) {
            ServiceRepository serviceRepository = new ServiceRepository(Driver.entityManager);
            service = (Service) action.getData();
            serviceRepository.save(service);
            message = "Service saved";
            code = ServerResponse.SAVE_SUCCEEDED;
        }

        response = new ServerResponse<Service>(message, code, service);
        return response;
    }

    /**
     * save a Bill
     * 
     * @param action
     * @return
     */
    ServerResponse saveBill(ServerRequest action) {
        int code = ServerResponse.SAVE_FAILED;
        String message = "Bill not saved.";
        ServerResponse response = null;
        Bill bill = null;

        // TODO:: Handle user save
        if (action.getData().getClass() == Bill.class) {
            BillRepository billRepository = new BillRepository(Driver.entityManager);
            bill = (Bill) action.getData();
            billRepository.save(bill);
            message = "Bill saved";
            code = ServerResponse.SAVE_SUCCEEDED;
        }

        response = new ServerResponse<Bill>(message, code, bill);
        return response;
    }

    /**
     * save a Payment
     * 
     * @param action
     * @return
     */
    ServerResponse savePayment(ServerRequest action) {
        int code = ServerResponse.SAVE_FAILED;
        String message = "Payment not saved.";
        ServerResponse response = null;
        Payment payment = null;

        // TODO:: Handle user save
        if (action.getData().getClass() == Payment.class) {
            PaymentRepository paymentRepository = new PaymentRepository(Driver.entityManager);
            payment = (Payment) action.getData();
            paymentRepository.save(payment);
            message = "Bill saved";
            code = ServerResponse.SAVE_SUCCEEDED;
        }

        response = new ServerResponse<Payment>(message, code, payment);
        return response;
    }

    /**
     * 
     * @param action
     * @return
     */
    ServerResponse loadAccount(ServerRequest action) {
        int code = ServerResponse.REQUEST_FAILED;
        String message = "User doesn't exist.";
        ServerResponse response = null;
        Account account = null;

        // TODO:: Handle user load
        if (action.getData().getClass() == Account.class) {
            System.out.println("This is a customer");

            AccountRepository accountRepository = new AccountRepository(Driver.entityManager);
            account = (Account) action.getData();

            // check if user id or username available
            if (account.getAccountID() > 0) {
                // load user by id
                account = accountRepository.findById(account.getAccountID());
            } else if (account.getCustomer() != null && account.getCustomer().getUserID() != 0) {
                // load user by username
                int customerId = account.getCustomer().getUserID();
                account = accountRepository.findByCustomerId(customerId);
            }

            if (account != null) {// TODO: check if users found
                message = "User found";
                code = ServerResponse.REQUEST_SUCCEEDED;
            }
            response = new ServerResponse<Account>(message, code, account);
        }

        return response;
    }

    /** ---------------------------------COMPLAINTS------------------------------ */

    ServerResponse loadComplaint(ServerRequest action) {
        boolean found = false;
        int code = ServerResponse.DELETE_FAILED;
        String message = "Complaint doesn't exist.";
        ServerResponse response;
        Complaint complaint = null;

        ComplaintRepository complaintRepository = new ComplaintRepository(Driver.entityManager);
        complaint = (Complaint) action.getData();

        // Check if complaint id available
        if (complaint.getComplaintId() > 0) {
            // load complaint by id
            complaint = complaintRepository.findById(complaint.getComplaintId()).get();
            found = true;
        }

        if (found) {
            message = "User found";
            code = ServerResponse.REQUEST_SUCCEEDED;
        }
        response = new ServerResponse<Complaint>(message, code, complaint);
        return response;
    }

    ServerResponse loadComplaints(ServerRequest action) {
        boolean found = false;
        int code = ServerResponse.REQUEST_FAILED;
        String message = "No Complaint Found.";
        ServerResponse response;

        ArrayList<Complaint> complaintsList = new ArrayList<>();

        if (true) {
            message = "Complaints Found";
            code = ServerResponse.REQUEST_SUCCEEDED;
            complaintsList.add(new Complaint());
        }

        response = new ServerResponse<ArrayList<Complaint>>(message, code, complaintsList);

        return response;
    }

    ServerResponse saveComplaint(ServerRequest action) {
        int code = ServerResponse.SAVE_FAILED;
        String message = "No Complaint found";
        ServerResponse response = null;
        Complaint complaint = null;

        ComplaintRepository complaintRepository = new ComplaintRepository(Driver.entityManager);
        complaint = (Complaint) action.getData();
        complaintRepository.save(complaint);
        message = "Complaint saved";
        code = ServerResponse.SAVE_SUCCEEDED;
        response = new ServerResponse<Complaint>(message, code, complaint);
        return response;
    }

    /** -------------------------------LIVE CHAT-------------------------------- */

    ServerResponse logOnUserToLiveChat(ServerRequest action) {
        // Check if user is a Customer or an Employee of type
        ServerResponse response = null;
        _User user = (_User) action.getData();

        // if Customer
        if (user.getClass().getSimpleName().equals("Customer")) {
            // Add customer to current list of online customers and change the status to
            // online
            user.setIsOnline(true);
            Server.activeLiveChatUsers.add(user);

            String message = "Login Successful";
            int code = ServerResponse.REQUEST_SUCCEEDED;
            response = new ServerResponse<ArrayList<_User>>(message, code, Server.activeLiveChatUsers);

        } else if (user.getClass().getSimpleName().equals("Employee")) {
            // Check for the type of Employee, It should be a Technician
            Employee employee = (Employee) user;

            if (employee.getRole().equals("Technician")) {
                // Add Technician to current list of online technicians and change the status to
                // online
                user.setIsOnline(true);
                Server.activeLiveChatUsers.add(user);

                String message = "Login Successful";
                int code = ServerResponse.REQUEST_SUCCEEDED;
                response = new ServerResponse<ArrayList<_User>>(message, code, Server.activeLiveChatUsers);

            } else if (employee.getRole().equals("Customer Service Rep") || employee.getRole().equals("Admin")) {
                // Don't allow them to log on to live chat
                ArrayList<_User> notAcceptedUsers = new ArrayList<>();

                String message = "Login Failed";
                int code = ServerResponse.REQUEST_FAILED;
                notAcceptedUsers.add(user);
                response = new ServerResponse<ArrayList<_User>>(message, code, notAcceptedUsers);
            }
        }
        return response;
    }

    ServerResponse logOffUserFromLiveChat(ServerRequest action) {
        // Check if user is a Customer or an Employee of type
        _User user = (_User) action.getData();

        user.setIsOnline(false);
        Server.activeLiveChatUsers.remove(user);

        ServerResponse response;
        String message = "Log Out Successful";
        int code = ServerResponse.REQUEST_SUCCEEDED;
        response = new ServerResponse<>(message, code, user);
        return response;
    }

}
