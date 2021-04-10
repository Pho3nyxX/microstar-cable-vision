package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Dashboard extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel startChatLabel;    
    JLabel repAvailableTxtLabel;   //TODO:: button that changes colour when avail/not avail - how to do this
    JLabel techAvailableTxtLabel;  //TODO:: button that changes colour when avail/not avail  - how to do this
    JLabel amountDueLabel;  
    JLabel amountDuetxtLabel;
    JLabel paymentStatusLabel;
    JLabel paidTxtLabel; //TODO:: shows paid/unpaid - how to do this
    JLabel paymentDueDateLabel;
    JLabel paymentDueDateTxtLabel;
    JLabel menuLabel;
    JLabel weekDayLabel; //TODO:: auto generate weekday
    JLabel dateLabel;  //TODO:: auto generate date
    JLabel microStarLabel;


    //these are menu drop downs
    JLabel signOutLabel; //TODO:: should be when "menu" is clicked, it drops this down
    JLabel profileLabel;  //TODO:: should be when "menu" is clicked, it drops this down


    //JTextArea: this is acture meant for a picture
    JTextArea pictureGoesHere;  //TODO:: TO BE REMOVED LATER

 
    // inputs
    JButton pastPaymentsBtn;  //this button takes you to the payment history page
    JButton pastComplaintsBtn;  //this button takes you to the complaint history page
    JButton lodgeComplaintsBtn;  //this button takes you to lodge complaint page


    /** -------------------------CONSTRUCTORS------------------------------- */ 
    
    public Dashboard() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");


        // button objects
        pastPaymentsBtn = new JButton("Past Payments");
        pastComplaintsBtn = new JButton("Past Complaints");
        lodgeComplaintsBtn = new JButton("Lodge Complaint");


        // JLabel objects
        startChatLabel = new JLabel("Start Chat");
        repAvailableTxtLabel = new JLabel("Rep Available");
        techAvailableTxtLabel = new JLabel("Technician Available");
        amountDueLabel = new JLabel("Amount Due");
        amountDuetxtLabel = new JLabel("0.00");
        paymentStatusLabel = new JLabel("Payment Status");
        paidTxtLabel = new JLabel("Paid");
        paymentDueDateLabel = new JLabel("Payment Due Date");
        paymentDueDateTxtLabel = new JLabel("0/00/0000");
        menuLabel = new JLabel("| Menu");
        weekDayLabel = new JLabel("Sunday");
        dateLabel = new JLabel("0 | 00 | 0000");


        // JTextArea objects
        pictureGoesHere = new JTextArea();  //TODO:: TO BE REMOVED LATER


        // setting the size of the labels
        microStarLabel.setBounds(10, 0, 350, 50);
        menuLabel.setBounds(150, 0, 350, 50);
        weekDayLabel.setBounds(450, 0, 150, 50);
        dateLabel.setBounds(450, 20, 150, 50);
        startChatLabel.setBounds(10, 90, 150, 20);
        repAvailableTxtLabel.setBounds(10, 110, 150, 20);
        //techAvailableTxtLabel.setBounds(10, 110, 150, 20);
        amountDueLabel.setBounds(170, 90, 150, 20);
        amountDuetxtLabel.setBounds(170, 110, 150, 20);
        paymentStatusLabel.setBounds(300, 90, 150, 20);
        paidTxtLabel.setBounds(300, 110, 150, 20);
        paymentDueDateLabel.setBounds(450, 90, 150, 20);
        paymentDueDateTxtLabel.setBounds(450, 110, 150, 20);
        pictureGoesHere.setBounds(170, 170, 380, 180);


        pastPaymentsBtn.setBounds(10, 370, 140, 40);
        pastComplaintsBtn.setBounds(10, 430, 140, 40);
        lodgeComplaintsBtn.setBounds(10, 490, 140, 40);


        // adding action listener to Past Payment Button button because it requires an action if
        // it is selected
        pastPaymentsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Past Complaint Button button because it requires an
        // action if it is selected
        pastComplaintsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Lodge Complaint Button button because it requires an
        // action if it is selected
        lodgeComplaintsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });


        // align Micro-Star Cable-Vision to the left
        microStarLabel.setHorizontalAlignment(JLabel.LEFT);


        // align Micro-Star Cable-Vision to the left
        //weekDayLabel.setHorizontalAlignment(JLabel.RIGHT);
        //dateLabel.setHorizontalAlignment(JLabel.RIGHT);


        // adding attributes
        this.add(microStarLabel);
        this.add(menuLabel);
        this.add(weekDayLabel);
        this.add(dateLabel);
        this.add(startChatLabel);
        this.add(repAvailableTxtLabel);
        //this.add(techAvailableTxtLabel);
        this.add(amountDueLabel);
        this.add(amountDuetxtLabel);
        this.add(paymentStatusLabel);
        this.add(paidTxtLabel);
        this.add(paymentDueDateLabel);
        this.add(paymentDueDateTxtLabel);
        this.add(pictureGoesHere);
        this.add(pastPaymentsBtn);
        this.add(pastComplaintsBtn);
        this.add(lodgeComplaintsBtn);
        


        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);


    }

  


    
}
