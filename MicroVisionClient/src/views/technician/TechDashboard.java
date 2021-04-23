package views.technician;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import views.livechat.ChatHome;

public class TechDashboard extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel welcomeLabel;
    JLabel weekDayLabel; 
    JLabel dateLabel; 
    JLabel microStarLabel;
    JLabel signLabel;
    JLabel taskLabel;
    JLabel titleLabel;
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel middleNameLabel;
    JLabel addressLabel;
    JLabel complaintTimeLabel;
    JLabel complaintLabel;
    JLabel detailsListLabel;
    JLabel detailsListWindowLabel;
    JLabel liveChatRequestsLabel;
    JLabel liveChatRequestsTxtLabel;

    JPanel topPanel;
    Border blueLine;
    Border raisedBevel;
    Color blueBackground;

    // JList
    JList<String> complaintList;

    JScrollPane complaintListScroller;
    JScrollPane detailsListScroller;

    // Panel for the details of the complaint
    JPanel detailsPanel;

    // comboboxes
    JComboBox<String> typeOfTaskCombobox;

    // combobox options
    String typeOfTask[] = {"Internet", "Phone", "Television" };

    // JButtons
    JButton respondBtn;
    JButton closeBtn;
    JButton availableForChatBtn;
    JButton joinChatBtn;

    Logger employeeAccess = LogManager.getLogger("EmployeeAccess");

    /** -------------------------CONSTRUCTORS------------------------------- */

    public TechDashboard() {

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

        // JLists
        String[] data = { "Task 1", "Task 2", "Task 3", "Task 4", "Task 5", "Task 6", "Task 7", "Task 8", "Task 9", "Task 10", "Task 11", "Task 12", "Task 13", "Task 14", "Task 15", "Task 16", "Task 17", "Task 18", "Task 19", "Task 20" };
        complaintList = new JList<String>(data);

        complaintList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintList.setLayoutOrientation(JList.VERTICAL);

        // add the jlist to the jscrollpane
        complaintListScroller = new JScrollPane(complaintList);

        detailsPanel = new JPanel();

        // button objects
        respondBtn = new JButton("Respond");
        closeBtn = new JButton("Close");
        availableForChatBtn = new JButton("AvailForChat");
        joinChatBtn = new JButton("JoinChat");

        // a string array of service list items
        typeOfTaskCombobox = new JComboBox<>(typeOfTask);

        // set one of the options as selected
        typeOfTaskCombobox.setSelectedItem(0);

        // JLabel objects
        welcomeLabel = new JLabel(
                "Welcome: " + Driver.CURRENT_USER.getfirstName() + " " + Driver.CURRENT_USER.getlastName());
        weekDayLabel = new JLabel(Driver.CURRENT_DAY);
        dateLabel = new JLabel(Driver.CURRENT_DATE);
        taskLabel = new JLabel("Tasks");
        titleLabel = new JLabel("Title");
        detailsListLabel = new JLabel("Details");
        liveChatRequestsLabel = new JLabel("LiveChat Request");
        liveChatRequestsTxtLabel = new JLabel("1");

        // labels within the new JPanel - details.
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        middleNameLabel = new JLabel("Middle Name:");
        addressLabel = new JLabel("Address:");
        complaintTimeLabel = new JLabel("Time Lodged:");
        complaintLabel = new JLabel("Complaint:");

        // setting the size of the labels
        microStarLabel.setBounds(10, 0, 350, 50);
        welcomeLabel.setBounds(410, 0, 200, 50);
        weekDayLabel.setBounds(410, 20, 100, 50);
        dateLabel.setBounds(480, 20, 150, 50);
        taskLabel.setBounds(10, 60, 150, 50);
        typeOfTaskCombobox.setBounds(50, 75, 85, 20);
        titleLabel.setBounds(10, 100, 150, 50);
        complaintListScroller.setBounds(10, 145, 130, 200);
        detailsListLabel.setBounds(300, 50, 130, 150);
        liveChatRequestsLabel.setBounds(360, 450, 120, 30);
        liveChatRequestsTxtLabel.setBounds(400, 460, 50, 50);

        // bounds being set on labels within the new JPanel - details.
        detailsPanel.setBounds(300, 145, 130, 200);
        firstNameLabel.setBounds(0, 0, 90, 20);
        lastNameLabel.setBounds(0, 30, 90, 20);
        middleNameLabel.setBounds(0, 60, 90, 20);
        addressLabel.setBounds(0, 90, 90, 20);
        complaintTimeLabel.setBounds(0, 120, 90, 20);
        complaintLabel.setBounds(0, 150, 90, 20);

        // setting bounds on buttons
        respondBtn.setBounds(300, 400, 90, 30);
        closeBtn.setBounds(430, 400, 90, 30);
        availableForChatBtn.setBounds(300, 510, 105, 30);
        joinChatBtn.setBounds(430, 510, 90, 30);

        // adding action listener to Respond Button button because it requires an action
        // if it is selected
        respondBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                ProposedVisit visit = new ProposedVisit(Driver.FRAME);
            }
        });

        // adding action listener to Close Button button because it requires an
        // action if it is selected
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Available Button button because it requires an
        // action if it is selected
        availableForChatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding action listener to Join Chat Button button because it requires an
        // action if it is selected
        joinChatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                employeeAccess.info("Join Chat Button clicked");
                new ChatHome();
            }
        });

        //listener for tasks
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                boolean adjust = listSelectionEvent.getValueIsAdjusting();
                if (!adjust) {
                    JList list = (JList) listSelectionEvent.getSource();
                    String value = (String)list.getSelectedValue();
                    System.out.println(value);
                }
                System.out.println();
            }
        };

        complaintList.addListSelectionListener(listSelectionListener);

        // adding items to details panel
        detailsPanel.add(firstNameLabel);
        detailsPanel.add(lastNameLabel);
        detailsPanel.add(middleNameLabel);
        detailsPanel.add(addressLabel);
        detailsPanel.add(complaintTimeLabel);
        detailsPanel.add(complaintLabel);

        detailsPanel.setLayout(null);

        // items being added to the new JPanel window
        this.add(detailsPanel);

        // adding attributes
        topPanel.add(microStarLabel);
        topPanel.add(welcomeLabel);
        topPanel.add(weekDayLabel);
        topPanel.add(dateLabel);
        this.add(taskLabel);
        this.add(typeOfTaskCombobox);
        this.add(titleLabel);
        this.add(complaintListScroller);
        this.add(detailsListLabel);
        this.add(respondBtn);
        this.add(closeBtn);
        this.add(liveChatRequestsLabel);
        this.add(liveChatRequestsTxtLabel);
        this.add(availableForChatBtn);
        this.add(joinChatBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);
    }

}
