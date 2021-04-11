package utilities.communication;

import driver.Driver;
import models.accounts.Account;
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
            ServerRequest action;
            objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());

            // this.configureStreams();
            // stmt = dBConn.createStatement();
            // result = s.executeQuery("SELECT * FROM user");
            /*
             * if(rs.next()){ System.out.println(rs.getString(2)); }
             */
            connection.warn("Attempting to receive data from client");
            action = (ServerRequest) objectInputStream.readObject();
            System.out.println("Log user in");
            connection.info("Data successfully received from client");
            // System.out.println(action.getClass());

            System.out.println(action);
            switch (action.getCommand()) {
                case ServerRequest.USER_LOGIN_COMMAND -> {
                    ServerResponse response = login(action);
                    objectOutputStream.writeObject(response);
                }
    
                case ServerRequest.USER_LOAD_COMMAND -> {
                    ServerResponse response = loadUser(action);
                    objectOutputStream.writeObject(response);
                }
    
                case ServerRequest.USER_LOAD_MANY_COMMAND -> {
                    ServerResponse response = loadUsers(action);
                    objectOutputStream.writeObject(response);
                }
                
                case ServerRequest.USER_UPDATE_COMMAND -> {
                    ServerResponse response = saveUser(action);
                    objectOutputStream.writeObject(response);
                }

                case ServerRequest.COMPLAINT_lOAD_COMMAND -> {
                    ServerResponse response = loadComplaint(action);
                    objectOutputStream.writeObject(response);
                }

                case ServerRequest.COMPLAINT_lOAD_MANY_COMMAND -> {
                    ServerResponse response = loadComplaints(action);
                    objectOutputStream.writeObject(response);
                }

                case ServerRequest.COMPLAINT_UPDATE_COMMAND -> {
                    ServerResponse response = saveComplaint(action);
                    objectOutputStream.writeObject(response);
                }
    
                case "User-Register" -> {
                    // Actions to register user
                }
    
                case ServerRequest.USER_LIVE_CHAT_COMMAND -> {
                    //Actions to log on live chat
                    ServerResponse response = logOnUserToLiveChat(action);
                    objectOutputStream.writeObject(response);
                }
                case ServerRequest.USER_END_CHAT_COMMAND -> {
                    //Actions to log the user off the live chat
                    ServerResponse response = logOffUserFromLiveChat(action);
                    objectOutputStream.writeObject(response);
                }
                case ServerRequest.USER_SEND_MESSAGE_LIVE_CHAT_COMMAND -> {
                    _Message message = (_Message) action.getData();
                    //Actions to send message

                    //Search for the recipient of the message in the connected clients list
                    for (MultipleClientHandler client:Server.activeClients) {
                        //Check if the recipient is an emplotyyee
                        for (_User onlineUser: Server.activeLiveChatUsers) {
                            if (message.getRecipientId() == onlineUser.getUserID() ) {
                                //Send message to that employee
                                ServerResponse response;
                                String responseMessage = "Incoming message";
                                int code = ServerResponse.REQUEST_SUCCEEDED;
                                response = new ServerResponse<_Message>(responseMessage,code,message);
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
                customer = customerRepository.findById(user.getUserID()).get();
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
                employee = employeeRepository.findById(user.getUserID()).get();
            } else if (!user.getUsername().isBlank() || user.getUsername() == null) {
                // load user by username
                employee = employeeRepository.findByUsername(user.getUsername());
            }
            // if(customer != null){
            // set the customer as the user to be return to the client
            user = employee;

        }

        if (true) {// TODO: check if users found
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
        ServerResponse response;
        ArrayList<_User> userList = new ArrayList();
        // TODO: load users
        if (true) {// TODO: check if users found
            message = "Users found"; // TODO: add user count to message
            code = ServerResponse.REQUEST_SUCCEEDED;
            userList.add(new Customer());
            userList.add(new Customer());
        } else {
            message = "No users found"; // TODO: add user count to message
            code = ServerResponse.REQUEST_FAILED;
        }
        response = new ServerResponse<ArrayList<_User>>(message, code, userList);
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
            response = new ServerResponse<Customer>(message, code, customer);
            message = "Customer saved";
            user = customer;
            code = ServerResponse.SAVE_SUCCEEDED;
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
     * @param action
     * @return
     */
    ServerResponse login(ServerRequest action) {
        // Actions for user login
        boolean loggedIn = false;
        int code = ServerResponse.REQUEST_FAILED;
        UUID sessionId = null;
        String message = "Login Failed.";
        ServerResponse response;
        CustomerRepository customerRepository = new CustomerRepository(Driver.entityManager);
        _User user = (_User)action.getData();
        
        // System.out.println(user.get);
        
        // System.out.println(action.getData().toString());
        Customer customer = null;
        customer = customerRepository.findByUsername(user.getUsername());
        if (customer != null) {
            if (customer.getPassword().equals(user.getPassword())) {
                user = customer;
            }else{
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

    /**---------------------------SERVICES & BILLING-------------------------------- */
    
    /**
     * 
     * @param action
     * @return
     */
    ServerResponse saveService(ServerRequest action) {
        int code = ServerResponse.SAVE_FAILED;
        String message = "No users found.";
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

    /**---------------------------------COMPLAINTS------------------------------*/

    ServerResponse loadComplaint(ServerRequest action) {
        boolean found = false;
        int code = ServerResponse.DELETE_FAILED;
        String message  = "Complaint doesn't exist.";
        ServerResponse response;
        Complaint complaint = null;

        ComplaintRepository complaintRepository = new ComplaintRepository(Driver.entityManager);
        complaint = (Complaint) action.getData();

        //Check if complaint id available
        if (complaint.getComplaintId() > 0) {
            //load complaint by id
            complaint = complaintRepository.findById(complaint.getComplaintId()).get();
            found = true;
        }

        if (found) {
            message = "User found";
            code = ServerResponse.REQUEST_SUCCEEDED;
        }
        response = new ServerResponse<Complaint>(message,code,complaint);
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

        response = new ServerResponse<ArrayList<Complaint>>(message,code,complaintsList);

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
        code=ServerResponse.SAVE_SUCCEEDED;
        response = new ServerResponse<Complaint>(message,code,complaint);
        return response;
    }


    /**-------------------------------LIVE CHAT--------------------------------*/

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

                String message = "Login Failed";
                int code = ServerResponse.REQUEST_FAILED;
                response = new ServerResponse<_User>(message, code, user);
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
