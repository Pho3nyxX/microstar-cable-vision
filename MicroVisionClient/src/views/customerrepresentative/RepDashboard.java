package views.customerrepresentative;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import views.livechat.ChatHome;

public class RepDashboard extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel welcomeLabel;
    JLabel weekDayLabel; // TODO:: auto generate weekday
    JLabel dateLabel; // TODO:: auto generate date
    JLabel microStarLabel;
    JLabel complaintsLabel;
    JLabel resolvedLabel; // TODO:: display number of resolved
    JLabel unresolvedLabel; // TODO:: display number of unresolved
    JLabel techniciansOnDutyLabel; // TODO:: display number of technicians on duty
    JLabel activeCustomersLabel; // TODO:: display number of active customers
    JLabel activeCustomersTxtLabel;
    JLabel liveChatRequestsLabel;
    JLabel liveChatRequestsTxtLabel;
    JLabel menuLabel;

    JPanel topPanel;
    Border blueLine;
    Border raisedBevel;
    Color blueBackground;

    // these are menu drop downs
    JLabel signOutLabel; // TODO:: should be when "menu" is clicked, it drops this down

    // JTextFields
    JTextField resolved1TxtField;
    JTextField resolved2TxtField;
    JTextField resolved3TxtField;
    JTextField resolved4TxtField;
    JTextField resolved5TxtField;

    // JTextArea
    JTextArea resolvedTxtArea; // TODO:: display the number
    JTextArea unresolvedTxtArea; // TODO:: display the number
    JTextArea techniciansOnDutyNumberTxtArea; // TODO:: display the number
    JTextArea techniciansOnDutyNamesTxtArea; // TODO:: display the names

    // JRadioButton
    JRadioButton internetRadioButton; // TODO:: if statement required for this
    JRadioButton phoneRadioButton; // TODO:: if statement required for this
    JRadioButton televisionRadioButton; // TODO:: if statement required for this

    // JButtons
    JButton viewBtn;
    JButton assignComplaintBtn;
    JButton startLiveChatBtn;

    Logger employeeAccess = LogManager.getLogger("EmployeeAccess");

    /** -------------------------CONSTRUCTORS------------------------------- */
    public RepDashboard() {
        
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

        // JTextField
        resolved1TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved2TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved3TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved4TxtField = new JTextField(); // TODO:: add "view" button on this
        resolved5TxtField = new JTextField(); // TODO:: add "view" button on this

        // button objects
        assignComplaintBtn = new JButton("Assign");
        startLiveChatBtn = new JButton("Start LiveChat");

        // JLabel objects
        welcomeLabel = new JLabel(
                "Welcome: " + Driver.CURRENT_USER.getfirstName() + " " + Driver.CURRENT_USER.getlastName());
        complaintsLabel = new JLabel("Complaints");
        resolvedLabel = new JLabel("Resolved");
        unresolvedLabel = new JLabel("Unresolved");
        techniciansOnDutyLabel = new JLabel("Technician on Duty");
        activeCustomersLabel = new JLabel("Active Customers");
        activeCustomersTxtLabel = new JLabel("00");
        liveChatRequestsLabel = new JLabel("LiveChat Request");
        liveChatRequestsTxtLabel = new JLabel("00");
        menuLabel = new JLabel("| Menu");
        weekDayLabel = new JLabel("Sunday");
        dateLabel = new JLabel("0 | 00 | 0000");

        // text fields objects
        resolvedTxtArea = new JTextArea("00");
        unresolvedTxtArea = new JTextArea("00");
        techniciansOnDutyNumberTxtArea = new JTextArea("00");
        techniciansOnDutyNamesTxtArea = new JTextArea();

        // Checkbox objects
        internetRadioButton = new JRadioButton("Internet");
        phoneRadioButton = new JRadioButton("Phone");
        televisionRadioButton = new JRadioButton("Television");

        //JRadioButton group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(internetRadioButton);
        buttonGroup.add(phoneRadioButton);
        buttonGroup.add(televisionRadioButton);

        // setting the size of the labels
        microStarLabel.setBounds(10, 0, 350, 50);
        menuLabel.setBounds(150, 0, 350, 50);
        welcomeLabel.setBounds(450, 0, 200, 50);
        weekDayLabel.setBounds(450, 20, 100, 50);
        dateLabel.setBounds(500, 20, 150, 50);
        complaintsLabel.setBounds(10, 60, 150, 50);
        internetRadioButton.setBounds(5, 100, 70, 50);
        phoneRadioButton.setBounds(90, 100, 70, 50);
        televisionRadioButton.setBounds(160, 100, 90, 50);
        resolvedLabel.setBounds(10, 140, 100, 50);
        resolvedTxtArea.setBounds(65, 160, 20, 12);
        unresolvedLabel.setBounds(100, 140, 110, 50);
        unresolvedTxtArea.setBounds(167, 160, 20, 12);
        resolved1TxtField.setBounds(10, 190, 230, 30);
        resolved2TxtField.setBounds(10, 225, 230, 30);
        resolved3TxtField.setBounds(10, 260, 230, 30);
        resolved4TxtField.setBounds(10, 295, 230, 30);
        resolved5TxtField.setBounds(10, 330, 230, 30);
        techniciansOnDutyLabel.setBounds(330, 60, 230, 50);
        techniciansOnDutyNumberTxtArea.setBounds(440, 80, 20, 12);
        techniciansOnDutyNamesTxtArea.setBounds(330, 120, 150, 150);
        activeCustomersLabel.setBounds(330, 350, 120, 30);
        activeCustomersTxtLabel.setBounds(370, 370, 50, 30);
        liveChatRequestsLabel.setBounds(450, 350, 120, 30);
        liveChatRequestsTxtLabel.setBounds(500, 360, 50, 50);

        assignComplaintBtn.setBounds(330, 280, 80, 30);
        startLiveChatBtn.setBounds(330, 410, 120, 30);

        // adding action listener to Assign Complaint button because it requires an
        // action if it is selected
        assignComplaintBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                employeeAccess.info("Employee Button Clicked. - Assigning Technician");
                AssignmentOfTechnician assignmentOfTechnician = new AssignmentOfTechnician(Driver.FRAME);
            }
        });

        // adding action listener to Start LiveChat button because it requires an action
        // if it is selected
        startLiveChatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start Chat Button clicked");
                employeeAccess.info("Start Chat Button clicked");
                new ChatHome();
            }
        });

        // align Micro-Star Cable-Vision to the left
        microStarLabel.setHorizontalAlignment(JLabel.LEFT);

        // adding attributes
        topPanel.add(microStarLabel);
        topPanel.add(welcomeLabel);
        topPanel.add(weekDayLabel);
        topPanel.add(dateLabel);
        this.add(menuLabel);
        this.add(complaintsLabel);
        this.add(internetRadioButton);
        this.add(phoneRadioButton);
        this.add(televisionRadioButton);
        this.add(resolvedLabel);
        this.add(resolvedTxtArea);
        this.add(unresolvedLabel);
        this.add(unresolvedTxtArea);
        this.add(resolved1TxtField);
        this.add(resolved2TxtField);
        this.add(resolved3TxtField);
        this.add(resolved4TxtField);
        this.add(resolved5TxtField);
        this.add(techniciansOnDutyLabel);
        this.add(techniciansOnDutyNumberTxtArea);
        this.add(techniciansOnDutyNamesTxtArea);
        this.add(assignComplaintBtn);
        this.add(activeCustomersLabel);
        this.add(activeCustomersTxtLabel);
        this.add(liveChatRequestsLabel);
        this.add(liveChatRequestsTxtLabel);
        this.add(startLiveChatBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

}
