package views.customerrepresentative;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AssignmentOfTechnician extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel assignedTechnicianLabel;
    JLabel customerNameLabel;
    JLabel typeOfServiceLabel;
    JLabel customerComplaintLabel;
    JLabel microStarLabel;
    JLabel assigningTechnicianLabel;


    // fields
    JTextField customerNameTxtField;
    JTextField assignedTechnicianTxtField;
    JTextArea customerComplaintTxtArea;


    // comboboxes
    JComboBox<String> typeOfServiceCombobox;

    // combobox options
    String typeOfService[] = { "Internet", "Phone", "Television" };

    // inputs
    JButton assign;
    JButton Dashboard;

    /** -------------------------CONSTRUCTORS------------------------------- */
    public AssignmentOfTechnician() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        assigningTechnicianLabel = new JLabel("Assigning Technician Form");

        // button objects
        JButton assignBtn = new JButton("Assign");
        JButton DashboardBtn = new JButton("Dashboard");

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
        DashboardBtn.setBounds(255, 340, 96, 40);

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
        DashboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // centering Micro-Star Cable-Vision and Assign Technician 
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        assigningTechnicianLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        this.add(microStarLabel);
        this.add(assigningTechnicianLabel);
        this.add(customerNameLabel);
        this.add(customerNameTxtField);
        this.add(assignedTechnicianLabel);
        this.add(assignedTechnicianTxtField);
        this.add(typeOfServiceLabel);
        this.add(typeOfServiceCombobox);
        this.add(customerComplaintLabel);
        this.add(customerComplaintTxtArea);
        this.add(microStarLabel);
        this.add(assigningTechnicianLabel);
        this.add(assignBtn);
        this.add(DashboardBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

}
