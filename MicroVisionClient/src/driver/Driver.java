package driver; 
import utilities.*;

import controllers.Authentication;
import javassist.bytecode.analysis.Frame;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

import models.users.*;
import utilities.communication.*;
import views.customer.CustomerDashboard;
import views.customer.Dashboard;
import views.customer.SignIn;
import views.customerrepresentative.AdminDashboard;
import views.customerrepresentative.RepDashboard;
import views.technician.TechDashboard;



public class Driver extends JFrame{
    
    public static Client clientConnection; //socket connection for general purpose use in the app
    public static Client messageConnection; //socket connection for use with chat
    public static _User CURRENT_USER; // the currently logged in user
    public static String SESSION_ID; //identifies a session based on user-id and a random string 
    public static String SESSION_TYPE; //Whether a use is an employee or a customer
    public static String APP_NAME = "MicroStar Cable Vision";
    public static String CURRENT_DATE = null;
    public static String CURRENT_DAY = null;
    public static Driver FRAME = null;
    
    
    //Logger  = LogManager.getLogger("logOut");
    
    public Driver() {

        super(Driver.APP_NAME);


        UIManager.getLookAndFeelDefaults()
        .put("defaultFont", new Font("Arial", Font.BOLD, 16));


        CURRENT_DATE = LocalDate.now().toString();
        CURRENT_DAY = LocalDate.now().getDayOfWeek().name();
        clientConnection = new Client();
        messageConnection = new Client();
    }
    

    public Driver(String title) {

        super(title);


        UIManager.getLookAndFeelDefaults()
        .put("defaultFont", new Font("Arial", Font.BOLD, 16));


        CURRENT_DATE = LocalDate.now().toString();
        CURRENT_DAY = LocalDate.now().getDayOfWeek().name();
        clientConnection = new Client();
        messageConnection = new Client();
    }


    public void buildCustomerMenu() {

        //menuBar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        //Menu items
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem logOut = new JMenuItem("LogOut");
        menu.add(logOut);
        JMenuItem startChat = new JMenuItem("Start Chat");
        menu.add(startChat);
        JMenuItem complaint = new JMenuItem("Complaint");
        menu.add(complaint);
        JMenuItem pastPayment = new JMenuItem("View Past Payment");
        menu.add(pastPayment);

        //View items
        JMenu view = new JMenu("View");
        menuBar.add(view);
        JMenuItem zoom = new JMenuItem("Zoom");
        view.add(zoom);
        JMenuItem nightMode = new JMenuItem("Night Mode");
        view.add(nightMode);

        //Services Offered items - Broadband
        JMenu servicesOffered = new JMenu("Services Offered");
        menuBar.add(servicesOffered);
        JMenu broadBand = new JMenu("BroadBand");
        servicesOffered.add(broadBand);
        JMenu about = new JMenu("About");
        broadBand.add(about);
        JMenuItem overview = new JMenuItem("Overview");
        about.add(overview);

        JMenu toolServices = new JMenu("Tools & Services");
        broadBand.add(toolServices);
        JMenuItem modemRouter = new JMenuItem("Modem & Router");
        toolServices.add(modemRouter);       
        JMenuItem speedTest = new JMenuItem("Speed Test");
        toolServices.add(speedTest);

        //Services Offered items - tv
        JMenu tv = new JMenu("Television");
        servicesOffered.add(tv);
        JMenu aboutTV = new JMenu("About");
        tv.add(aboutTV);
        JMenuItem overview1 = new JMenuItem("Overview");
        aboutTV.add(overview1);

        JMenu channels = new JMenu("Channels");
        tv.add(channels);
        JMenuItem lineUp = new JMenuItem("LineUp");
        channels.add(lineUp);

        JMenu questions = new JMenu("Questions");
        tv.add(questions);
        JMenuItem faq = new JMenuItem("FAQ");
        questions.add(faq);

        //Services Offered items - phone
        JMenu phone = new JMenu("Phone");
        servicesOffered.add(phone);
        JMenu aboutPhone = new JMenu("About");
        phone.add(aboutPhone);
        JMenuItem overview2 = new JMenuItem("Overview");
        aboutPhone.add(overview2);

        JMenu rates = new JMenu("Rates");
        phone.add(rates);
        JMenuItem international = new JMenuItem("International");
        rates.add(international);

        JMenu questions1 = new JMenu("Questions");
        phone.add(questions1);
        JMenuItem faq1 = new JMenuItem("FAQ");
        questions1.add(faq1);
        
        //Services Offered items - internet
        JMenu internet = new JMenu("Internet");
        servicesOffered.add(internet);
        JMenu aboutInternet = new JMenu("About");
        internet.add(aboutInternet);
        JMenuItem overview3 = new JMenuItem("Overview");
        aboutInternet.add(overview3);

        JMenu questions2 = new JMenu("Questions");
        internet.add(questions2);
        JMenuItem faq2 = new JMenuItem("FAQ");
        questions2.add(faq2);
    }


public void buildAdminMenu() {

    //menuBar
    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    //Menu items
    JMenu menu = new JMenu("Menu");
    menuBar.add(menu);
    JMenuItem logOut = new JMenuItem("LogOut");
    menu.add(logOut);
    
    logOut.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            Authentication authentication = new Authentication();
            authentication.logout(SESSION_ID);

            Driver.FRAME.setVisible(false);

            Driver.FRAME.init();

            //allow user to login
            if(Driver.FRAME.login()){

                //shows main window
                Driver.FRAME.setVisible(true);

            } else{

                System.exit(0);
    
            } 

        }
    });


    JMenuItem startChat = new JMenuItem("Start Chat");
    menu.add(startChat);
    JMenu complaint = new JMenu("Complaint");
    menu.add(complaint);

    //resolved items
    JMenu resolved = new JMenu("Resolved");
    complaint.add(resolved);
    JMenuItem internet = new JMenuItem("Internet");
    resolved.add(internet);
    JMenuItem tv = new JMenuItem("Television");
    resolved.add(tv);
    JMenuItem phone = new JMenuItem("Phone");
    resolved.add(phone);

    //unresolved items
    JMenu unresolved = new JMenu("Unresolved");
    complaint.add(unresolved);
    JMenuItem internet1 = new JMenuItem("Internet");
    unresolved.add(internet1);
    JMenuItem tv1 = new JMenuItem("Television");
    unresolved.add(tv1);
    JMenuItem phone1 = new JMenuItem("Phone");
    unresolved.add(phone1);

    JMenu create = new JMenu("Create");
    menuBar.add(create);
    JMenuItem createCustomer = new JMenuItem("Create Customer");
    create.add(createCustomer);
    JMenuItem createEmployee = new JMenuItem("Create Employee");
    create.add(createEmployee);


    JMenu view = new JMenu("View");
    menuBar.add(view);
    JMenuItem zoom = new JMenuItem("Zoom");
    view.add(zoom);
    JMenuItem nightMode = new JMenuItem("Night Mode");
    view.add(nightMode);

}


public void buildTechnicianMenu() {

    //menuBar
    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    //Menu items
    JMenu menu = new JMenu("Menu");
    menuBar.add(menu);
    JMenuItem logOut = new JMenuItem("LogOut");
    menu.add(logOut);
    JMenuItem joinChat = new JMenuItem("Join Chat");
    menu.add(joinChat);
    JMenu tasks = new JMenu("Tasks");
    menu.add(tasks);
    JMenuItem internet = new JMenuItem("Internet");
    tasks.add(internet);
    JMenuItem tv = new JMenuItem("Television");
    tasks.add(tv);
    JMenuItem phone = new JMenuItem("Phone");
    tasks.add(phone);

    //Create items
    JMenu create = new JMenu("Create");
    menuBar.add(create);
    JMenuItem response = new JMenuItem("Response");
    create.add(response);

    //View items
    JMenu view = new JMenu("View");
    menuBar.add(view);
    JMenuItem zoom = new JMenuItem("Zoom");
    view.add(zoom);
    JMenuItem nightMode = new JMenuItem("Night Mode");
    view.add(nightMode);

}


public void buildRepMenu() {

    //menuBar
    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    //Menu items
    JMenu menu = new JMenu("Menu");
    menuBar.add(menu);
    JMenuItem logOut = new JMenuItem("LogOut");
    menu.add(logOut);
    JMenuItem startChat = new JMenuItem("Start Chat");
    menu.add(startChat);
    JMenu complaint = new JMenu("Complaint");
    menu.add(complaint);

    //resolved items
    JMenu resolved = new JMenu("Resolved");
    complaint.add(resolved);
    JMenuItem internet = new JMenuItem("Internet");
    resolved.add(internet);
    JMenuItem tv = new JMenuItem("Television");
    resolved.add(tv);
    JMenuItem phone = new JMenuItem("Phone");
    resolved.add(phone);

    //unresolved items
    JMenu unresolved = new JMenu("Unresolved");
    complaint.add(unresolved);
    JMenuItem internet1 = new JMenuItem("Internet");
    unresolved.add(internet1);
    JMenuItem tv1 = new JMenuItem("Television");
    unresolved.add(tv1);
    JMenuItem phone1 = new JMenuItem("Phone");
    unresolved.add(phone1);

    JMenu view = new JMenu("View");
    menuBar.add(view);
    JMenuItem zoom = new JMenuItem("Zoom");
    view.add(zoom);
    JMenuItem nightMode = new JMenuItem("Night Mode");
    view.add(nightMode);

}

/**
 * creates the driver which is the main frame for the app
 * driver is stored in static FRAME
 */
    public static void init() {

        Driver.FRAME = null; //sets FRAME to null in case a frame had been created before. This allows it to be garbage collected.

        Driver driver = new Driver();
        
        Driver.FRAME = driver;

    }

/**
 * shows a login dialog and allows the user to login 
 * after which the appropriate dashboard is displayed
 * @return
 */
    public boolean login(){

        SignIn signInDialog = new SignIn(Driver.FRAME);
        
        // if session type is not empty a user was logged in
        if (SESSION_TYPE != null && !SESSION_TYPE.isEmpty() )  {
            
            // checking if its customer
            if (SESSION_TYPE.equals("Customer"))  {
            
                CustomerDashboard dashboard = new CustomerDashboard();
                
                dashboard.setBounds(0, 0, 700, 700);
                
                Driver.FRAME.buildCustomerMenu();
                
                Driver.FRAME.add(dashboard);
            
            // checking if the employee is "Rep", "Customer Rep" or "Tech" and supply the with their respective dashboard
            } else if(SESSION_TYPE.equals("Employee")) {
                
                //check if customer rep
                if (((Employee)CURRENT_USER).getRole().equals(Employee.ROLE_CUSTOMER_REP)) {
                    
                    RepDashboard repDashboard = new RepDashboard();
                    repDashboard.setBounds(0, 0, 700, 700);
            
                    Driver.FRAME.buildRepMenu();
                    
                    Driver.FRAME.add(repDashboard);
                    
                    //check if admin
                } else if(((Employee)CURRENT_USER).getRole().equals(Employee.ROLE_ADMIN)) {
            
                    AdminDashboard adminDashboard = new AdminDashboard();
                    adminDashboard.setBounds(0, 0, 700, 700);
            
                    Driver.FRAME.buildAdminMenu();
            
                    Driver.FRAME.add(adminDashboard);
                
            
                } else {

                    TechDashboard techDashboard = new TechDashboard();
                    techDashboard.setBounds(0, 0, 700, 700);
            
                    Driver.FRAME.buildTechnicianMenu();
            
                    Driver.FRAME.add(techDashboard);
                    
                }
            }
            
        }else{

            return false;

        }

        return true;

    }
    
    /**
     * sets the main window visibility depending on the value passed in
     */
    public void setVisible(boolean visible){

        // set window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close app when window is closed
        this.setSize(610, 650); // set panel window size
        this.setLayout(null);

        super.setVisible(visible);

    }

    public static void main(String[] args) throws Exception {
        
        //initialise window
        Driver.init();

        //allow user to login
        if(Driver.FRAME.login()){

            //show main window
            Driver.FRAME.setVisible(true);

        } else{

            System.exit(0);

        }    


/*
        // Authentication auth =  new Authentication();
        // auth.login("admin", "P@ssword123"); 
        // ArrayList<Customer> customers = Customer.loadCustomers();
        
        // Customer customer = new Customer(0, "abi5", "abi", "gordon", "middleName", "P@ssword123", 10, "F", "email2@server.com", new Address("parish", "town","street"));
        // Customer customer = new Customer(0, "abi5", "abi", "gordon", "middleName", "P@ssword123", 10, "F", "email2@server.com", new Address("parish", "town","street"));
        // customer.save();
        // customer.setUserID(1);
        // customer.refresh();

        // Service service = new Service(0, Service.SERVICE_BROADBAND, LocalDate.now(), _Service.SERVICE_STATUS_ACTIVE, 1);
        // service.save();
        // Bill bill = new Bill(0, LocalDate.now(), LocalDate.now(), LocalDate.now(), 1000, LocalDate.now(), 5);
        // bill.save();
        Payment payment = new Payment(0, 1000, "", LocalDate.now(), 1);
        payment.save();
        
        */
    }


}
