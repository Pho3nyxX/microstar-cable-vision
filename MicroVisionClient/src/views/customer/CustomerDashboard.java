package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import views.livechat.ChatHome;

public class CustomerDashboard extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel welcomeLabel;
    JLabel repAvailableTxtLabel; // TODO:: button that changes colour when avail/not avail - how to do this
    JLabel techAvailableTxtLabel; // TODO:: button that changes colour when avail/not avail - how to do this
    JLabel amountDueLabel;
    JLabel amountDuetxtLabel;
    JLabel paymentStatusLabel;
    JLabel paidTxtLabel; // TODO:: shows paid/unpaid - how to do this
    JLabel paymentDueDateLabel;
    JLabel paymentDueDateTxtLabel;
    JLabel weekDayLabel; // TODO:: auto generate weekday
    JLabel dateLabel; // TODO:: auto generate date
    JLabel microStarLabel;

    // these are menu drop downs
    JLabel signOutLabel; // TODO:: should be when "menu" is clicked, it drops this down
    JLabel profileLabel; // TODO:: should be when "menu" is clicked, it drops this down

    // JTextArea: this is acture meant for a picture
    JTextArea pictureGoesHere; // TODO:: TO BE REMOVED LATER

    // inputs
    JButton startChatBtn;
    JButton pastPaymentsBtn; // this button takes you to the payment history page
    JButton pastComplaintsBtn; // this button takes you to the complaint history page
    JButton lodgeComplaintsBtn; // this button takes you to lodge complaint page

    //Logger for tracking customer
    Logger customerAccess = LogManager.getLogger("CustomerAccess");
    /** -------------------------CONSTRUCTORS------------------------------- */

    public CustomerDashboard() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");

        // button objects
        startChatBtn = new JButton("Start Chat");
        pastPaymentsBtn = new JButton("Past Payments");
        pastComplaintsBtn = new JButton("Past Complaints");
        lodgeComplaintsBtn = new JButton("Lodge Complaint");

        // JLabel objects
        welcomeLabel = new JLabel("Welcome: " + Driver.CURRENT_USER.getfirstName() + " " + Driver.CURRENT_USER.getlastName());
        repAvailableTxtLabel = new JLabel("Rep Available");
        techAvailableTxtLabel = new JLabel("Technician Available");
        amountDueLabel = new JLabel("Amount Due");
        amountDuetxtLabel = new JLabel("$5,000");
        paymentStatusLabel = new JLabel("Payment Status");
        paidTxtLabel = new JLabel("UnPaid");
        paymentDueDateLabel = new JLabel("Payment Due Date");
        paymentDueDateTxtLabel = new JLabel("1/05/2021");
        weekDayLabel = new JLabel(Driver.CURRENT_DAY);
        dateLabel = new JLabel(Driver.CURRENT_DATE);

        // JTextArea objects
        pictureGoesHere = new JTextArea(); // TODO:: TO BE REMOVED LATER

        // setting the size of the labels
        microStarLabel.setBounds(10, 0, 350, 50);
        welcomeLabel.setBounds(430, 0, 200, 50);
        weekDayLabel.setBounds(430, 20, 100, 50);
        dateLabel.setBounds(500, 20, 150, 50);
        repAvailableTxtLabel.setBounds(10, 120, 150, 20);
        amountDueLabel.setBounds(170, 90, 150, 20);
        amountDuetxtLabel.setBounds(170, 110, 150, 20);
        paymentStatusLabel.setBounds(300, 90, 150, 20);
        paidTxtLabel.setBounds(300, 110, 150, 20);
        paymentDueDateLabel.setBounds(450, 90, 150, 20);
        paymentDueDateTxtLabel.setBounds(450, 110, 150, 20);
        pictureGoesHere.setBounds(170, 170, 380, 180);
        
        // setting the size of the labels buttons
        startChatBtn.setBounds(10, 90, 100, 30);
        pastPaymentsBtn.setBounds(10, 370, 140, 40);
        pastComplaintsBtn.setBounds(10, 430, 140, 40);
        lodgeComplaintsBtn.setBounds(10, 490, 140, 40);


       // adding action listener to Past Payment Button button because it requires an
        // action if
        // it is selected
        startChatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start Chat Button clicked");
                customerAccess.info("Start Chat Button clicked");
                new ChatHome();
            }
        });
        // adding action listener to Past Payment Button button because it requires an
        // action if
        // it is selected
        pastPaymentsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                ViewPastPayment pastPayment = new ViewPastPayment(Driver.FRAME);
            }
        });

        // adding action listener to Past Complaints Button button because it requires
        // an
        // action if it is selected
        pastComplaintsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                ViewPastComplaints pastComplaint = new ViewPastComplaints(Driver.FRAME);
            }
        });

        // adding action listener to Lodge Complaints Button button because it requires
        // an
        // action if it is selected
        lodgeComplaintsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                ComplaintForm complaintForm = new ComplaintForm(Driver.FRAME);
            }
        });

        // align Micro-Star Cable-Vision to the left
        microStarLabel.setHorizontalAlignment(JLabel.LEFT);

        // adding attributes
        this.add(microStarLabel);
        this.add(welcomeLabel);
        this.add(weekDayLabel);
        this.add(dateLabel);
        this.add(repAvailableTxtLabel);
        this.add(amountDueLabel);
        this.add(amountDuetxtLabel);
        this.add(paymentStatusLabel);
        this.add(paidTxtLabel);
        this.add(paymentDueDateLabel);
        this.add(paymentDueDateTxtLabel);
        this.add(pictureGoesHere);
        this.add(startChatBtn);
        this.add(pastPaymentsBtn);
        this.add(pastComplaintsBtn);
        this.add(lodgeComplaintsBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

}
