package views.customer;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import java.awt.Color;

public class SpecificComplaint extends JDialog {

    /** -------------------------MEMBERS------------------------------- */

    // container
    JPanel contentPanel;

    // labels
    JLabel titleLabel;
    JLabel dateMadeLabel;
    JLabel complaintLabel;
    JLabel reponseDateLabel;
    JLabel reponseLabel;
    JLabel respondeeLabel;
    JLabel microStarLabel;
    JLabel complaintHeaderLabel;

    JLabel titleTxtField;
    JLabel dateMadeTxtField;
    JLabel complaintTxtField;
    JLabel responseDateTxtField;
    JLabel responseTxtField;
    JLabel respondeeTxtField;

    JPanel topPanel;
    Border blueLine;
    Border raisedBevel;
    Color blueBackground;

    // JTextArea
    JTextArea complaintTxtArea;

    // JButton
    JButton dashboardBtn;

    Logger customer = LogManager.getLogger("CustomerAccess");

    /** -------------------------CONSTRUCTORS------------------------------- */

    public SpecificComplaint(Frame parent) {

        super(parent, "Complaint", true);

        blueBackground = new Color(41, 193, 239);

        // JPanel objects
        topPanel = new JPanel();

        // set background colour to panel
        topPanel.setBackground(blueBackground);

        // setting the size of the panel
        topPanel.setBounds(0, 0, 1000, 70);

        this.add(topPanel);

        blueLine = BorderFactory.createLineBorder(blueBackground);
        raisedBevel = BorderFactory.createRaisedBevelBorder();

        topPanel.setLayout(null);

        // button objects
        dashboardBtn = new JButton("Dashboard");

        dashboardBtn.setBackground(blueBackground);

        dashboardBtn.setForeground(Color.WHITE);

        contentPanel = new JPanel();

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        complaintHeaderLabel = new JLabel("Complaint");

        // JLabel objects
        titleLabel = new JLabel("Title");
        dateMadeLabel = new JLabel("Date Made");
        complaintLabel = new JLabel("Complaint");
        reponseDateLabel = new JLabel("Response Date");
        respondeeLabel = new JLabel("Respondee");
        reponseLabel = new JLabel("Response");

        // JTextArea objects
        complaintTxtArea = new JTextArea();

        // JTextField objects
        titleTxtField = new JLabel("Fire");
        dateMadeTxtField = new JLabel("0/00/0000");
        complaintTxtField = new JLabel("**********");
        responseDateTxtField = new JLabel("0/00/0000");
        respondeeTxtField = new JLabel("Jane Doe");
        responseTxtField = new JLabel("Sorry To Hear!");

        // setting the size of the labels
        microStarLabel.setBounds(00, 0, 350, 50);
        complaintHeaderLabel.setBounds(50, 30, 250, 50);
        titleLabel.setBounds(10, 70, 200, 80);
        dateMadeLabel.setBounds(10, 110, 200, 80);
        complaintLabel.setBounds(10, 150, 200, 80);
        reponseDateLabel.setBounds(10, 190, 200, 80);
        respondeeLabel.setBounds(10, 230, 200, 80);
        reponseLabel.setBounds(10, 270, 200, 80);

        // setting the size of text field sizes
        titleTxtField.setBounds(150, 100, 150, 20);
        dateMadeTxtField.setBounds(150, 140, 150, 20);
        complaintTxtField.setBounds(150, 180, 150, 20);
        responseDateTxtField.setBounds(150, 220, 150, 20);
        respondeeTxtField.setBounds(150, 260, 150, 20);
        responseTxtField.setBounds(150, 300, 150, 20);

        dashboardBtn.setBounds(50, 340, 98, 30);

        // adding action listener to Dashboard button because it requires an action if
        // it is selected
        dashboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.info("Dashboard Button Clicked. - Returning to Dashboard.");
                dispose();
                CustomerDashboard dashboard = new CustomerDashboard();
                dashboard.setBounds(0, 0, 700, 700);

                Driver.FRAME.add(dashboard);
            }
        });

        // centering Micro-Star Cable-Vision and Register
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        complaintHeaderLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        topPanel.add(microStarLabel);
        topPanel.add(complaintHeaderLabel);
        contentPanel.add(titleLabel);
        contentPanel.add(titleTxtField);
        contentPanel.add(dateMadeLabel);
        contentPanel.add(dateMadeTxtField);
        contentPanel.add(complaintLabel);
        contentPanel.add(complaintTxtField);
        contentPanel.add(reponseDateLabel);
        contentPanel.add(responseDateTxtField);
        contentPanel.add(respondeeLabel);
        contentPanel.add(respondeeTxtField);
        contentPanel.add(reponseLabel);
        contentPanel.add(responseTxtField);
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
