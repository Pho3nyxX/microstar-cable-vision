package views.customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import AppPackage.AnimationClass;
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
    JLabel slideshowImage1;
    JLabel slideshowImage2;

    //JPanel slideshowPanel;

    JPanel topPanel;
    Border blueLine;
    Border raisedBevel;
    Color blueBackground;

    // these are menu drop downs
    JLabel signOutLabel; // TODO:: should be when "menu" is clicked, it drops this down
    JLabel profileLabel; // TODO:: should be when "menu" is clicked, it drops this down

    // inputs
    JButton startChatBtn;
    JButton pastPaymentsBtn; // this button takes you to the payment history page
    JButton pastComplaintsBtn; // this button takes you to the complaint history page
    JButton lodgeComplaintsBtn; // this button takes you to lodge complaint page

    //Logger for tracking customer
    Logger customerAccess = LogManager.getLogger("CustomerAccess");

    AnimationClass animationClass = new AnimationClass();
    /** -------------------------CONSTRUCTORS------------------------------- */

    public CustomerDashboard() {

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
        slideshowImage1 = new JLabel();
        slideshowImage2 = new JLabel();

        //slideshowPanel = new JPanel();
        //slideshowPanel.setLayout(null);

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
        slideshowImage1.setBounds(170,170,380,180); //170,170
        slideshowImage2.setBounds(595,170,380,180);

        //slideshowPanel.setBounds(170,170,380,180);
        
        // setting the size of the labels buttons
        startChatBtn.setBounds(10, 90, 100, 30);
        pastPaymentsBtn.setBounds(10, 370, 140, 40);
        pastComplaintsBtn.setBounds(10, 430, 140, 40);
        lodgeComplaintsBtn.setBounds(10, 490, 140, 40);

        slideshowImage1.setIcon(new ImageIcon("MicroVisionClient/image/CustomerImage1.jpg"));
        slideshowImage2.setIcon(new ImageIcon("MicroVisionClient/image/CustomerImage3.jpg"));

        slideshow();

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
        topPanel.add(microStarLabel);
        topPanel.add(welcomeLabel);
        topPanel.add(weekDayLabel);
        topPanel.add(dateLabel);
        this.add(repAvailableTxtLabel);
        this.add(amountDueLabel);
        this.add(amountDuetxtLabel);
        this.add(paymentStatusLabel);
        this.add(paidTxtLabel);
        this.add(paymentDueDateLabel);
        this.add(paymentDueDateTxtLabel);
        this.add(slideshowImage1);
        this.add(slideshowImage2);
        this.add(startChatBtn);
        this.add(pastPaymentsBtn);
        this.add(pastComplaintsBtn);
        this.add(lodgeComplaintsBtn);

        //this.add(slideshowPanel);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

    private void slideshow() {
        new Thread() {
            int count=0;
            public void run() {
                try {
                    while (true) {
                        switch (count) {
                            case 0 -> {
                                ImageIcon slideshowIcon1 = new ImageIcon("MicroVisionClient/image/CustomerImage3.jpg");
                                slideshowImage2.setIcon(slideshowIcon1);
                                Thread.sleep(6000);
                                //2380 milliseconds
                                animationClass.jLabelXRight(170, 595, 20, 5, slideshowImage1);
                                animationClass.jLabelXLeft(595, 170, 20, 5, slideshowImage2);
                                count = 1;
                            }
                            case 1 -> {
                                ImageIcon slideshowIcon2 = new ImageIcon("MicroVisionClient/image/CustomerImage4.jpg");
                                slideshowImage1.setIcon(slideshowIcon2);
                                Thread.sleep(6000);
                                //2380 milliseconds
                                animationClass.jLabelXRight(170, 595, 20, 5, slideshowImage2);
                                animationClass.jLabelXLeft(595, 170, 20, 5, slideshowImage1);
                                count = 2;
                            }
                            case 2 -> {
                                ImageIcon slideshowIcon3 = new ImageIcon("MicroVisionClient/image/CustomerImage5.jpg");
                                slideshowImage2.setIcon(slideshowIcon3);
                                Thread.sleep(6000);
                                //2380 milliseconds
                                animationClass.jLabelXRight(170, 595, 20, 5, slideshowImage1);
                                animationClass.jLabelXLeft(595, 170, 20, 5, slideshowImage2);
                                count = 3;
                            }
                            case 3 -> {
                                ImageIcon slideshowIcon4 = new ImageIcon("MicroVisionClient/image/CustomerImage1.jpg");
                                slideshowImage1.setIcon(slideshowIcon4);
                                Thread.sleep(6000);
                                //2380 milliseconds
                                animationClass.jLabelXRight(170, 595, 20, 5, slideshowImage2);
                                animationClass.jLabelXLeft(595, 170, 20, 5, slideshowImage1);
                                count = 0;
                            }
                        }
                    }
                }catch (InterruptedException ex) {
                    System.out.println("Sleep Error");
                }
            }
        }.start();
    }

}
