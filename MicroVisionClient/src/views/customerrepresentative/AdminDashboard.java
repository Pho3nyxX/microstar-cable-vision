package views.customerrepresentative;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import views.livechat.ChatHome;

public class AdminDashboard  extends JPanel implements ActionListener  {
    
    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel welcomeLabel;
    JLabel weekDayLabel; 
    JLabel dateLabel; 
    JLabel microStarLabel;
    JLabel complaintsLabel;
    JLabel resolvedLabel; // TODO:: display number of resolved
    JLabel unresolvedLabel; // TODO:: display number of unresolved
    JLabel techniciansOnDutyLabel; // TODO:: display number of technicians on duty
    JLabel activeCustomersLabel; // TODO:: display number of active customers
    JLabel activeCustomersTxtLabel;
    JLabel liveChatRequestsLabel;
    JLabel liveChatRequestsTxtLabel;

    // these are menu drop downs
    JLabel signOutLabel; 

    JPanel topPanel;
    Border blueLine;
    Border raisedBevel;
    Color blueBackground;

    // JTextFields
    JTextField resolved1TxtField;
    JTextField resolved2TxtField;
    JTextField resolved3TxtField;
    JTextField resolved4TxtField;
    JTextField resolved5TxtField;

    // JTextArea
    JTextArea resolvedTxtArea; // TODO:: display the number
    JTextArea unresolvedTxtArea; // TODO:: display the number
    JTextArea techniciansOnDutyNumberTxtArea; // TODO:: display the number
    JTextArea techniciansOnDutyNamesTxtArea; // TODO:: display the names

    // JRadioButtons
    JRadioButton internetRadioButton; // TODO:: if statement required for this
    JRadioButton phoneRadioButton; // TODO:: if statement required for this
    JRadioButton televisionRadioButton; // TODO:: if statement required for this

    // JButtons
    JButton viewBtn;
    JButton assignComplaintBtn;
    JButton startLiveChatBtn;
    JButton createCustomerBtn;
    JButton createEmployeeBtn;

    Logger employeeAccess = LogManager.getLogger("EmployeeAccess");

    /** -------------------------CONSTRUCTORS------------------------------- */
    public AdminDashboard() {

        //colour object
        blueBackground = new Color(41,193,239);

        //JPanel objects
        topPanel = new JPanel();

        //set background colour to panel
        topPanel.setBackground(blueBackground);

        //setting the size of the panel
        topPanel.setBounds(0,0,1200,60);

        this.add(topPanel);

        blueLine = BorderFactory.createLineBorder(blueBackground);
        raisedBevel = BorderFactory.createRaisedBevelBorder();

        topPanel.setLayout(null);




        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");

        // JTextField
        resolved1TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved2TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved3TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved4TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved5TxtField = new JTextField(); // TODO:: add "view" button on this

        // button objects
        assignComplaintBtn = new JButton("Assign");
        startLiveChatBtn = new JButton("Start LiveChat");
        createCustomerBtn = new JButton("Create Customer");
        createEmployeeBtn = new JButton("Create Employee");


        // JLabel objects
        welcomeLabel = new JLabel(
                "Welcome: " + Driver.CURRENT_USER.getfirstName() + " " + Driver.CURRENT_USER.getlastName());
        complaintsLabel = new JLabel("Complaints");
        resolvedLabel = new JLabel("Resolved");
        unresolvedLabel = new JLabel("Unresolved");
        techniciansOnDutyLabel = new JLabel("Technician on Duty");
        activeCustomersLabel = new JLabel("Active Customers");
        activeCustomersTxtLabel = new JLabel("1");
        liveChatRequestsLabel = new JLabel("LiveChat Request");
        liveChatRequestsTxtLabel = new JLabel("1");
        weekDayLabel = new JLabel(Driver.CURRENT_DAY);
        dateLabel = new JLabel(Driver.CURRENT_DATE);

        // text fields objects
        resolvedTxtArea = new JTextArea("5");
        unresolvedTxtArea = new JTextArea("1");
        techniciansOnDutyNumberTxtArea = new JTextArea("1");
        techniciansOnDutyNamesTxtArea = new JTextArea();

        // JRadioButton objects
        internetRadioButton = new JRadioButton("Internet");
        phoneRadioButton = new JRadioButton("Phone");
        televisionRadioButton = new JRadioButton("Television");

        //JRadioButton group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(internetRadioButton);
        buttonGroup.add(phoneRadioButton);
        buttonGroup.add(televisionRadioButton);

        // setting the size of the labels
        microStarLabel.setBounds(10, 0, 350, 50);
        welcomeLabel.setBounds(430, 0, 200, 50);
        weekDayLabel.setBounds(430, 20, 100, 50);
        dateLabel.setBounds(500, 20, 150, 50);
        complaintsLabel.setBounds(10, 60, 150, 50);
        internetRadioButton.setBounds(5, 100, 70, 50);
        phoneRadioButton.setBounds(90, 100, 70, 50);
        televisionRadioButton.setBounds(160, 100, 90, 50);
        resolvedLabel.setBounds(10, 140, 100, 50);
        resolvedTxtArea.setBounds(65, 160, 20, 12);
        unresolvedLabel.setBounds(100, 140, 110, 50);
        unresolvedTxtArea.setBounds(167, 160, 20, 12);
        resolved1TxtField.setBounds(10, 190, 230, 30);
        resolved2TxtField.setBounds(10, 225, 230, 30);
        resolved3TxtField.setBounds(10, 260, 230, 30);
        resolved4TxtField.setBounds(10, 295, 230, 30);
        resolved5TxtField.setBounds(10, 330, 230, 30);
        techniciansOnDutyLabel.setBounds(330, 60, 230, 50);
        techniciansOnDutyNumberTxtArea.setBounds(440, 80, 20, 12);
        techniciansOnDutyNamesTxtArea.setBounds(330, 120, 150, 150);
        activeCustomersLabel.setBounds(330, 350, 120, 30);
        activeCustomersTxtLabel.setBounds(370, 370, 50, 30);
        liveChatRequestsLabel.setBounds(450, 350, 120, 30);
        liveChatRequestsTxtLabel.setBounds(500, 360, 50, 50);

        assignComplaintBtn.setBounds(330, 280, 80, 30);
        startLiveChatBtn.setBounds(370, 410, 120, 30);
        createCustomerBtn.setBounds(10, 380, 140, 30);
        createEmployeeBtn.setBounds(10, 430, 140, 30);


        // adding action listener to Assign Complaint button because it requires an
        // action if it is selected
        assignComplaintBtn.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Button clicked");
                employeeAccess.info("Employee Button Clicked. - Assigning Technician");
                AssignmentOfTechnician assignmentOfTechnician = new AssignmentOfTechnician(Driver.FRAME);
            }
        });


        // adding action listener to Start LiveChat button because it requires an action
        // if it is selected
        startLiveChatBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Start Chat Button clicked");
                employeeAccess.info("Start Chat Button clicked");
                JOptionPane.showMessageDialog(null,"Login as Technician to use Live Chat",
                        "Live Chat",JOptionPane.WARNING_MESSAGE);
            }
        });


        // adding action listener to Create Customer button because it requires an
        // action if it is selected
        createCustomerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Button clicked");
                employeeAccess.info("Create Customer Button clicked");
                RegisterCustomer reg = new RegisterCustomer(Driver.FRAME);
            }
        });


        // adding action listener to Create Employee button because it requires an action
        // if it is selected
        createEmployeeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Button clicked");
                employeeAccess.info("Create Employee Button clicked");
                RegisterEmployee reg = new RegisterEmployee(Driver.FRAME);
            }
        });


        //Register a listener for the radio buttons.
        internetRadioButton.addActionListener(this);
        phoneRadioButton.addActionListener(this);
        televisionRadioButton.addActionListener(this);


        // align Micro-Star Cable-Vision to the left
        microStarLabel.setHorizontalAlignment(JLabel.LEFT);

        // adding attributes
        topPanel.add(microStarLabel);
        topPanel.add(welcomeLabel);
        topPanel.add(weekDayLabel);
        topPanel.add(dateLabel);
        this.add(complaintsLabel);
        this.add(internetRadioButton);
        this.add(phoneRadioButton);
        this.add(televisionRadioButton);
        this.add(resolvedLabel);
        this.add(resolvedTxtArea);
        this.add(unresolvedLabel);
        this.add(unresolvedTxtArea);
        this.add(resolved1TxtField);
        this.add(resolved2TxtField);
        this.add(resolved3TxtField);
        this.add(resolved4TxtField);
        this.add(resolved5TxtField);
        this.add(techniciansOnDutyLabel);
        this.add(techniciansOnDutyNumberTxtArea);
        this.add(techniciansOnDutyNamesTxtArea);
        this.add(assignComplaintBtn);
        this.add(activeCustomersLabel);
        this.add(activeCustomersTxtLabel);
        this.add(liveChatRequestsLabel);
        this.add(liveChatRequestsTxtLabel);
        this.add(startLiveChatBtn);
        this.add(createCustomerBtn);
        this.add(createEmployeeBtn);




        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("action");
    }
}
