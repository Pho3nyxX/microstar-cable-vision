package views.customerrepresentative;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.users.Employee;

public class RegisterEmployee extends JDialog {

    /** -------------------------MEMBERS------------------------------- */
    //container
    JPanel contentPanel;

    // labels
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel middleNameLabel;
    JLabel userNameLabel;
    JLabel ageLabel;
    JLabel genderLabel;
    JLabel contactLabel;
    JLabel roleLabel;

    // combobox
    JComboBox<String> selectRoleCombobox;

    // combobox options
    String selectRole[] = { Employee.ROLE_CUSTOMER_REP, Employee.ROLE_ADMIN, Employee.ROLE_TECH };

    JLabel microStarLabel;
    JLabel registerLabel;

    // fields
    JTextField firstNameTxtField;
    JTextField lastNameTxtField;
    JTextField middleNameTxtField;
    JTextField usernameTxtField;
    JTextField ageTxtField;
    JTextField genderTxtField;
    JTextField contactTxtField;


    // inputs
    JButton saveBtn;
    JButton cancelBtn;

    /** -------------------------CONSTRUCTORS------------------------------- */

    public RegisterEmployee(Frame parent) {

        super(parent, "Register Employee", true);

        contentPanel = new JPanel();

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        registerLabel = new JLabel("Register Employee");

        // button objects
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");

        // JLabel objects
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        middleNameLabel = new JLabel("Middle Name");
        userNameLabel = new JLabel("Username");
        ageLabel = new JLabel("Age");
        genderLabel = new JLabel("Gender");
        contactLabel = new JLabel("Contact");
        roleLabel = new JLabel("Role");

        // a string array of service list items
        selectRoleCombobox = new JComboBox<>(selectRole);

        // set one of the options as selected
        selectRoleCombobox.setSelectedItem(0);

        // JTextField objects
        firstNameTxtField = new JTextField();
        lastNameTxtField = new JTextField();
        middleNameTxtField = new JTextField();
        usernameTxtField = new JTextField();
        ageTxtField = new JTextField();
        genderTxtField = new JTextField();
        contactTxtField = new JTextField();


        // setting the size of the labels
        firstNameLabel.setBounds(10, 100, 150, 20);
        lastNameLabel.setBounds(10, 150, 150, 20);
        middleNameLabel.setBounds(10, 200, 150, 20);
        userNameLabel.setBounds(10, 250, 150, 20);
        ageLabel.setBounds(10, 300, 150, 20);
        genderLabel.setBounds(10, 350, 150, 20);
        contactLabel.setBounds(10, 400, 150, 20);
        roleLabel.setBounds(10, 460, 150, 20);
        microStarLabel.setBounds(00, 0, 350, 50);
        registerLabel.setBounds(50, 30, 250, 50);

        // setting the size of text field sizes
        firstNameTxtField.setBounds(150, 90, 220, 40);
        lastNameTxtField.setBounds(150, 140, 220, 40);
        middleNameTxtField.setBounds(150, 190, 220, 40);
        usernameTxtField.setBounds(150, 240, 220, 40);
        ageTxtField.setBounds(150, 290, 220, 40);
        genderTxtField.setBounds(150, 340, 220, 40);
        contactTxtField.setBounds(150, 390, 220, 40);
        selectRoleCombobox.setBounds(150, 450, 220, 40);


        saveBtn.setBounds(150, 520, 98, 40);
        cancelBtn.setBounds(270, 520, 98, 40);

        // adding action listener to Save Button button because it requires an action if
        // it is selected
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Cancel Button button because it requires an
        // action if it is selected
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // centering Micro-Star Cable-Vision and Register 
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        registerLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        contentPanel.add(microStarLabel);
        contentPanel.add(registerLabel);
        contentPanel.add(firstNameLabel);
        contentPanel.add(firstNameTxtField);
        contentPanel.add(lastNameLabel);
        contentPanel.add(lastNameTxtField);
        contentPanel.add(middleNameLabel);
        contentPanel.add(middleNameTxtField);
        contentPanel.add(userNameLabel);
        contentPanel.add(usernameTxtField);
        contentPanel.add(ageLabel);
        contentPanel.add(ageTxtField);
        contentPanel.add(genderLabel);
        contentPanel.add(genderTxtField);
        contentPanel.add(contactLabel);
        contentPanel.add(contactTxtField);
        contentPanel.add(roleLabel);
        contentPanel.add(selectRoleCombobox);

        contentPanel.add(saveBtn);
        contentPanel.add(cancelBtn);

        contentPanel.setLayout(null);
        contentPanel.setBounds(0,0,520,610);

        this.add(contentPanel);

        this.setLayout(null);
        this.setSize(450,680);

        // making GUI visable
        this.setVisible(true);
    }

}
