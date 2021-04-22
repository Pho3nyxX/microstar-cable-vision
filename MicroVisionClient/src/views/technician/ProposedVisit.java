package views.technician;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.View;

public class ProposedVisit extends JDialog {

    /** -------------------------MEMBERS------------------------------- */

    // container
    JPanel contentPanel;

    // labels
    JLabel responseLabel;
    JLabel proposedDateOfVisitLabel;
    JLabel proposedTimeOfVisitLabel;
    JLabel microStarLabel;
    JLabel visitLabel;

    // comboboxes
    JComboBox<String> proposedDateOfVisitMonthCombobox;
    JComboBox<String> proposedDateOfVisitDayCombobox;
    JComboBox<String> proposedDateOfVisitYearCombobox;
    JComboBox<String> proposedTimeOfVisitHourCombobox;
    JComboBox<String> proposedTimeOfVisitMinsCombobox;

    // combobox options
    String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" }; // TODO:: write code to generate available month
    String day[] = { " 1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "20", "31" }; // TODO:: write code to generate available date
    String year[] = { "2021", "2022", "2023", "2024", "2025" }; // TODO:: write code to generate available year
    String hour[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }; // TODO:: write code to generate available hour
    String mins[] = { "00", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35" }; // TODO:: write code to generate available mins

    // inputs
    JButton notifyCustomerBtn;
    JButton submitBtn;
    JButton dashboardBtn;

    Logger employee = LogManager.getLogger("EmployeeAccess");

    /** -------------------------CONSTRUCTORS------------------------------- */

    public ProposedVisit(Frame parent) {

        super(parent, "Proposed Visit Schedule", true);

        contentPanel = new JPanel();

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        visitLabel = new JLabel("Proposed Visit Form");

        // JText object
        JTextArea responseTxtArea = new JTextArea();

        // button objects
        notifyCustomerBtn = new JButton("Notify Customer");
        submitBtn = new JButton("Submit");
        dashboardBtn = new JButton("Dashboard");

        // JLabel objects
        responseLabel = new JLabel("Response");
        proposedDateOfVisitLabel = new JLabel("Proposed Date of Visit");
        proposedTimeOfVisitLabel = new JLabel("Proposed Time of Visit");

        // a string array of service list items
        proposedDateOfVisitMonthCombobox = new JComboBox<>(month);
        proposedDateOfVisitDayCombobox = new JComboBox<>(day);
        proposedDateOfVisitYearCombobox = new JComboBox<>(year);
        proposedTimeOfVisitHourCombobox = new JComboBox<>(hour);
        proposedTimeOfVisitMinsCombobox = new JComboBox<>(mins);

        // set one of the options as selected
        proposedDateOfVisitMonthCombobox.setSelectedItem(0);
        proposedDateOfVisitDayCombobox.setSelectedItem(0);
        proposedDateOfVisitYearCombobox.setSelectedItem(0);
        proposedTimeOfVisitHourCombobox.setSelectedItem(0);
        proposedTimeOfVisitMinsCombobox.setSelectedItem(0);

        // setting the size of the labels
        microStarLabel.setBounds(00, 0, 350, 50);
        visitLabel.setBounds(50, 30, 250, 50);
        responseLabel.setBounds(10, 100, 150, 20);
        proposedDateOfVisitLabel.setBounds(10, 160, 150, 20);
        proposedTimeOfVisitLabel.setBounds(10, 220, 150, 20);

        // setting the size of text field sizes
        responseTxtArea.setBounds(170, 90, 200, 40);
        proposedDateOfVisitMonthCombobox.setBounds(170, 150, 50, 40);
        proposedDateOfVisitDayCombobox.setBounds(240, 150, 50, 40);
        proposedDateOfVisitYearCombobox.setBounds(310, 150, 60, 40);
        proposedTimeOfVisitHourCombobox.setBounds(170, 210, 50, 40);
        proposedTimeOfVisitMinsCombobox.setBounds(240, 210, 50, 40);

        notifyCustomerBtn.setBounds(10, 270, 140, 40);
        submitBtn.setBounds(170, 270, 80, 40);
        dashboardBtn.setBounds(270, 270, 100, 40);

        // adding action listener to Notify Customer button button because it requires
        // an action if it is selected
        notifyCustomerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Submit Button button because it requires an action
        // if it is selected
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Dashboard button because it requires an action if
        // it is selected
        dashboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                employee.info("Dashboard Button Clicked. - Returning to Technician Dashboard");
                dispose();
                TechDashboard techDashboard = new TechDashboard();
                techDashboard.setBounds(0, 0, 700, 700);
                Driver.FRAME.add(techDashboard);
            }
        });

        // centering Micro-Star Cable-Vision and Complaint Form
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        visitLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        contentPanel.add(microStarLabel);
        contentPanel.add(visitLabel);
        contentPanel.add(responseLabel);
        contentPanel.add(responseTxtArea);
        contentPanel.add(proposedDateOfVisitLabel);
        contentPanel.add(proposedDateOfVisitMonthCombobox);
        contentPanel.add(proposedDateOfVisitDayCombobox);
        contentPanel.add(proposedDateOfVisitYearCombobox);
        contentPanel.add(proposedTimeOfVisitLabel);
        contentPanel.add(proposedTimeOfVisitHourCombobox);
        contentPanel.add(proposedTimeOfVisitMinsCombobox);
        contentPanel.add(notifyCustomerBtn);
        contentPanel.add(submitBtn);
        contentPanel.add(dashboardBtn);

        contentPanel.setLayout(null);
        contentPanel.setBounds(0, 0, 600, 680);

        this.add(contentPanel);

        this.setLayout(null);
        this.setSize(400, 400);

        // making GUI visable
        this.setVisible(true);

    }

}
