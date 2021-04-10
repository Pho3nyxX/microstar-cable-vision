package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewPastComplaints extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel selectTypeOfServiceLabel;
    JLabel selectComplaintLabel;
    JLabel lastResponseDateLabel;
    JLabel RespondeeLabel;
    JLabel MicroStarLabel;
    JLabel PastComplaintsLabel;

    // comboboxes
    JComboBox<String> selectTypeOfServiceCombobox;
    JComboBox<String> selectComplaintCombobox;

    // combobox options
    String selectTypeOfService[] = { "Internet", "Phone", "Television" };
    String selectComplaint[] = { "Fire", "Damaged Cord", "Internet Outage", "Cable Outage", "Incorrect Billing" };

    // inputs
    JButton viewBtn;
    JButton DashboardBtn;

    /** -------------------------CONSTRUCTORS------------------------------- */
    public ViewPastComplaints() {

        // JLabel objects
        MicroStarLabel = new JLabel("Micro-Star Cable-Vision");
        PastComplaintsLabel = new JLabel("Complaint History");

        // button objects
        viewBtn = new JButton("View");
        DashboardBtn = new JButton("Dashboard");

        // JLabel objects
        selectTypeOfServiceLabel = new JLabel("Select Type of Service");
        selectComplaintLabel = new JLabel("Select Complaint");
        lastResponseDateLabel = new JLabel("Last Response Date");
        RespondeeLabel = new JLabel("Respondee");
        JLabel lastResponseDateLabelField = new JLabel("Sunday, January 1, 2000");
        JLabel RespondeeLabelField = new JLabel("Technician Jane Doe");

        // a string array of service list items
        selectTypeOfServiceCombobox = new JComboBox<>(selectTypeOfService);
        selectComplaintCombobox = new JComboBox<>(selectComplaint);

        // set one of the options as selected
        selectTypeOfServiceCombobox.setSelectedItem(0);
        selectComplaintCombobox.setSelectedItem(0);

        // setting the size of the labels
        selectTypeOfServiceLabel.setBounds(10, 100, 150, 20);
        selectComplaintLabel.setBounds(10, 150, 150, 20);
        lastResponseDateLabel.setBounds(10, 200, 150, 20);
        RespondeeLabel.setBounds(10, 250, 150, 20);
        MicroStarLabel.setBounds(00, 0, 350, 50);
        PastComplaintsLabel.setBounds(50, 30, 250, 50);

        // setting the size of text field sizes
        selectTypeOfServiceCombobox.setBounds(150, 90, 200, 40);
        selectComplaintCombobox.setBounds(150, 140, 200, 40);
        lastResponseDateLabelField.setBounds(150, 190, 200, 40);
        RespondeeLabelField.setBounds(150, 240, 200, 40);

        viewBtn.setBounds(150, 300, 80, 40);
        DashboardBtn.setBounds(245, 300, 100, 40);

        // adding action listener to View Button button because it requires an action if
        // it is selected
        viewBtn.addActionListener(new ActionListener() {
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

        // centering Micro-Star Cable-Vision and Complaint Form
        MicroStarLabel.setHorizontalAlignment(JLabel.CENTER);
        PastComplaintsLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        this.add(MicroStarLabel);
        this.add(PastComplaintsLabel);
        this.add(selectTypeOfServiceLabel);
        this.add(selectTypeOfServiceCombobox);
        this.add(selectComplaintLabel);
        this.add(selectComplaintCombobox);
        this.add(lastResponseDateLabel);
        this.add(lastResponseDateLabelField);
        this.add(RespondeeLabel);
        this.add(RespondeeLabelField);
        this.add(viewBtn);
        this.add(DashboardBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

}
