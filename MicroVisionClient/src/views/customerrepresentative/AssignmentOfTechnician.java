package views.customerrepresentative;

import driver.Driver;
import models.users.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import views.customer.CustomerDashboard;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;

public class AssignmentOfTechnician extends JDialog {

    /** -------------------------MEMBERS------------------------------- */

    // container
    JPanel contentPanel;

    // labels
    JLabel assignedTechnicianLabel;
    JLabel customerNameLabel;
    JLabel typeOfServiceLabel;
    JLabel customerComplaintLabel;
    JLabel microStarLabel;
    JLabel assigningTechnicianLabel;

    JPanel topPanel;
    Border blueLine;
    Border raisedBevel;
    Color blueBackground;

    // fields
    JTextField customerNameTxtField;
    JTextField assignedTechnicianTxtField;
    JTextArea customerComplaintTxtArea;

    // comboboxes
    JComboBox<String> typeOfServiceCombobox;

    // combobox options
    String typeOfService[] = { "Internet", "Phone", "Television" };

    // inputs
    JButton assignBtn;
    JButton dashboardBtn;

    Logger employee = LogManager.getLogger("EmployeeAccess");

    /** -------------------------CONSTRUCTORS------------------------------- */

    public AssignmentOfTechnician(Frame parent) {

        super(parent, "Assignment Form", true);

        blueBackground = new Color(41, 193, 239);

        // JPanel objects
        topPanel = new JPanel();

        // set background colour to panel
        topPanel.setBackground(blueBackground);

        // setting the size of the panel
        topPanel.setBounds(0, 0, 1000, 68);

        this.add(topPanel);

        blueLine = BorderFactory.createLineBorder(blueBackground);
        raisedBevel = BorderFactory.createRaisedBevelBorder();

        topPanel.setLayout(null);

        // button objects
        assignBtn = new JButton("Assign");
        dashboardBtn = new JButton("Dashboard");

        assignBtn.setBackground(blueBackground);
        dashboardBtn.setBackground(blueBackground);

        assignBtn.setForeground(Color.WHITE);
        dashboardBtn.setForeground(Color.WHITE);

        contentPanel = new JPanel();

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        assigningTechnicianLabel = new JLabel("Assigning Technician Form");

        // JLabel objects
        assignedTechnicianLabel = new JLabel("Technician's Name");
        customerNameLabel = new JLabel("Customer's Name");
        typeOfServiceLabel = new JLabel("Type of Service");
        customerComplaintLabel = new JLabel("Customer Complaint"); // TODO:: load complaint here

        // JTextField objects
        customerNameTxtField = new JTextField();
        assignedTechnicianTxtField = new JTextField();

        // JTextArea objects
        customerComplaintTxtArea = new JTextArea();

        // a string array of service list items
        typeOfServiceCombobox = new JComboBox<>(typeOfService);

        // set one of the options as selected
        typeOfServiceCombobox.setSelectedItem(0);

        // setting the size of the labels
        customerNameLabel.setBounds(10, 100, 150, 20);
        assignedTechnicianLabel.setBounds(10, 150, 150, 20);
        typeOfServiceLabel.setBounds(10, 200, 150, 20);
        customerComplaintLabel.setBounds(10, 250, 150, 20);
        microStarLabel.setBounds(00, 0, 350, 50);
        assigningTechnicianLabel.setBounds(50, 30, 250, 50);

        // setting the size of text field sizes
        customerNameTxtField.setBounds(150, 90, 200, 40);
        assignedTechnicianTxtField.setBounds(150, 140, 200, 40);
        typeOfServiceCombobox.setBounds(150, 190, 200, 40);
        customerComplaintTxtArea.setBounds(150, 240, 200, 80);

        assignBtn.setBounds(150, 340, 95, 40);
        dashboardBtn.setBounds(255, 340, 96, 40);

        // adding action listener to View Button button because it requires an action if
        // it is selected
        assignBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");

            }
        });

        // adding action listener to Dashboard Button button because it requires an
        // action if it is selected
        dashboardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Dashboard Button clicked");
                employee.info("Dashboard Button Clicked.");
                dispose();

                if (((Employee)Driver.CURRENT_USER).getRole().equals(Employee.ROLE_CUSTOMER_REP)) {

                    employee.info("Returning to Rep Dashboard");
                    RepDashboard repDashboard = new RepDashboard();
                    repDashboard.setBounds(0, 0, 700, 700);
                    Driver.FRAME.add(repDashboard);

                }else if (((Employee)Driver.CURRENT_USER).getRole().equals(Employee.ROLE_ADMIN)) {

                    employee.info("Returning to Admin Dashboard");
                    AdminDashboard adminDashboard = new AdminDashboard();
                    adminDashboard.setBounds(0, 0, 700, 700);
                    Driver.FRAME.add(adminDashboard);
                }
            }
        });

        // centering Micro-Star Cable-Vision and Assign Technician
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        assigningTechnicianLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        topPanel.add(microStarLabel);
        topPanel.add(assigningTechnicianLabel);
        contentPanel.add(customerNameLabel);
        contentPanel.add(customerNameTxtField);
        contentPanel.add(assignedTechnicianLabel);
        contentPanel.add(assignedTechnicianTxtField);
        contentPanel.add(typeOfServiceLabel);
        contentPanel.add(typeOfServiceCombobox);
        contentPanel.add(customerComplaintLabel);
        contentPanel.add(customerComplaintTxtArea);
        contentPanel.add(assignBtn);
        contentPanel.add(dashboardBtn);

        contentPanel.setLayout(null);
        contentPanel.setBounds(0, 0, 600, 680);

        this.add(contentPanel);

        this.setLayout(null);
        this.setSize(400, 450);

        // making GUI visable
        this.setVisible(true);

    }

}
