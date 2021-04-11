package views.customerrepresentative;

import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterCustomer extends JDialog {

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
    JLabel streetLabel;
    JLabel townLabel;
    JLabel parishLabel;
    JLabel contactLabel;
    JLabel emailLabel;
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
    JTextField emailTxtField;
    JTextField streetTxtField;
    JTextField townTxtField;
    JTextField parishTxtField;

    // inputs
    JButton saveBtn;
    JButton cancelBtn;

    /** -------------------------CONSTRUCTORS------------------------------- */

    public RegisterCustomer(Frame parent) {

        super(parent, "Register Customer", true);

        contentPanel = new JPanel();

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        registerLabel = new JLabel("Register Customer");

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
        emailLabel = new JLabel("Email Address");
        streetLabel = new JLabel("Street");
        townLabel = new JLabel("Town");
        parishLabel = new JLabel("Parish");

        // JTextField objects
        firstNameTxtField = new JTextField();
        lastNameTxtField = new JTextField();
        middleNameTxtField = new JTextField();
        usernameTxtField = new JTextField();
        ageTxtField = new JTextField();
        genderTxtField = new JTextField();
        contactTxtField = new JTextField();
        emailTxtField = new JTextField();
        streetTxtField = new JTextField();
        townTxtField = new JTextField();
        parishTxtField = new JTextField();

        // setting the size of the labels
        firstNameLabel.setBounds(10, 100, 150, 20);
        lastNameLabel.setBounds(10, 150, 150, 20);
        middleNameLabel.setBounds(10, 200, 150, 20);
        userNameLabel.setBounds(10, 250, 150, 20);
        ageLabel.setBounds(10, 300, 150, 20);
        genderLabel.setBounds(10, 350, 150, 20);
        contactLabel.setBounds(10, 400, 150, 20);
        emailLabel.setBounds(10, 450, 150, 20);
        streetLabel.setBounds(10, 500, 150, 20);
        townLabel.setBounds(10, 545, 150, 20);
        parishLabel.setBounds(10, 600, 150, 20);  
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
        emailTxtField.setBounds(150, 440, 220, 40);
        streetTxtField.setBounds(150, 490, 220, 40);
        townTxtField.setBounds(150, 540, 220, 40);
        parishTxtField.setBounds(150, 590, 220, 40);

        saveBtn.setBounds(150, 640, 98, 40);
        cancelBtn.setBounds(270, 640, 98, 40);

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
                dispose();
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
        contentPanel.add(emailLabel);
        contentPanel.add(emailTxtField);
        contentPanel.add(streetLabel);
        contentPanel.add(townLabel);
        contentPanel.add(parishLabel);
        contentPanel.add(streetTxtField);
        contentPanel.add(townTxtField);
        contentPanel.add(parishTxtField);
        contentPanel.add(saveBtn);
        contentPanel.add(cancelBtn);

        contentPanel.setLayout(null);
        contentPanel.setBounds(0,0,600,680);
        
        this.add(contentPanel);

        this.setLayout(null);
        this.setSize(450,800);
        
        // making GUI visable
        this.setVisible(true);
    }

}
