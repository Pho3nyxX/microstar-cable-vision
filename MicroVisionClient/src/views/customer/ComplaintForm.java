package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComplaintForm extends JPanel {

    /**-------------------------MEMBERS------------------------------- */
    //inputs
    JTextArea lodgeComplaintTxtArea;
    JButton submitBtn;
    JButton cancelBtn;
    
    // labels
    JLabel selectTypeOfServiceLabel;
    JLabel lodgeComplaintLabel;
    JLabel selectMethodOfContactLabel;
    JLabel MicroStarLabel;
    JLabel ComplaintFormLabel;
    
    //comboboxes
    JComboBox<String> selectTypeOfServiceCombobox;
    JComboBox<String> selectMethodOfContactCombobox;
    
    // combobox options
    String typesOfService[] = { "Internet", "Phone", "Television" };
    String methodsOfContact[] = { "Phone", "Email" };
    
    // containers
    JScrollPane lodgeComplaintScroller;


    /**-------------------------CONSTRUCTORS------------------------------- */
    public ComplaintForm() {

        // JLabel objects
        MicroStarLabel = new JLabel("Micro-Star Cable-Vision");
        ComplaintFormLabel = new JLabel("Complaint Form");


        // text fields objects
        lodgeComplaintTxtArea = new JTextArea();
        lodgeComplaintScroller = new JScrollPane();
        submitBtn = new JButton("Submit");
        cancelBtn = new JButton("Cancel");


        // JLabel objects
        selectTypeOfServiceLabel = new JLabel("Select Type of Service");
        lodgeComplaintLabel = new JLabel("Lodge Complaint");
        selectMethodOfContactLabel = new JLabel("Select Contact Method");


        // a string array of service list items
        selectTypeOfServiceCombobox = new JComboBox<>(typesOfService);
        selectMethodOfContactCombobox = new JComboBox<>(methodsOfContact);


        // set one of the options as selected
        selectTypeOfServiceCombobox.setSelectedItem(0);
        selectMethodOfContactCombobox.setSelectedItem(0);


        // setting the size of the labels
        selectTypeOfServiceLabel.setBounds(10, 100, 150, 20);
        lodgeComplaintLabel.setBounds(10, 150, 150, 20);
        selectMethodOfContactLabel.setBounds(10, 250, 150, 20);


        // setting the size of text field sizes
        MicroStarLabel.setBounds(00, 0, 350, 50);
        ComplaintFormLabel.setBounds(50, 30, 250, 50);

        selectTypeOfServiceCombobox.setBounds(150, 90, 200, 40);
        lodgeComplaintTxtArea.setBounds(0, 0, 150, 100); // TODO:: fix scroll pane
        lodgeComplaintScroller.setBounds(150, 140, 200, 100); // TODO:: fix scroll pane
        selectMethodOfContactCombobox.setBounds(150, 250, 200, 40);
        submitBtn.setBounds(150, 300, 95, 40);
        cancelBtn.setBounds(255, 300, 95, 40);


        // adding action listener to Submit button because it requires an action if it
        // is selected
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Cancel button because it requires an action if it
        // is selected
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // centering Micro-Star Cable-Vision and Complaint Form
        MicroStarLabel.setHorizontalAlignment(JLabel.CENTER);
        ComplaintFormLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        lodgeComplaintScroller.add(lodgeComplaintTxtArea);
        
        this.add(MicroStarLabel);
        this.add(ComplaintFormLabel);
        this.add(selectTypeOfServiceCombobox);
        this.add(lodgeComplaintScroller); // TODO:: fix scroll pane
        this.add(selectMethodOfContactCombobox);
        this.add(submitBtn);
        this.add(cancelBtn);

        // adding labels to panel
        this.add(selectTypeOfServiceLabel);
        this.add(lodgeComplaintLabel);
        this.add(selectMethodOfContactLabel);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

    

}
