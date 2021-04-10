package views.technician;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class TechDashboard extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
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
    JLabel weekDayLabel; // TODO:: auto generate weekday
    JLabel dateLabel; // TODO:: auto generate date
    JLabel microStarLabel;
    JLabel signLabel;
    JLabel menuLabel;

    // JList
    JList<String> complaintList;

    JScrollPane complaintListScroller;
    JScrollPane detailsListScroller;

    // Panel for the details of the complaint
    JPanel detailsPanel;

    // comboboxes
    JComboBox<String> typeOfTaskCombobox;

    // combobox options
    String typeOfTask[] = { "None", "Internet", "Phone", "Television" };

    // JButtons
    JButton respondBtn;
    JButton closeBtn;
    JButton availableForChatBtn;
    JButton joinChatBtn;

    /** -------------------------CONSTRUCTORS------------------------------- */

    public TechDashboard() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");

        // JLists
        String[] data = { "Task1", "Task2", "Task3", "Task4", "Task5", "Task6", "Task7", "Task8", "Task9", "Task10" };
        complaintList = new JList<String>(data);

        complaintList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintList.setLayoutOrientation(JList.VERTICAL);

        // add the jlist to the jscrollpane
        complaintListScroller = new JScrollPane(complaintList);
        // complaintListScroller.setMinimumSize(new Dimension(100, 50));
        /*
         * 
         * JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroller,
         * contentPanel);
         * 
         * max 5 tasks will be shown at a time list.setVisibleRowCount(5);
         * 
         */

        detailsPanel = new JPanel();

        // button objects
        JButton respondBtn = new JButton("Respond");
        JButton closeBtn = new JButton("Close");
        JButton availableForChatBtn = new JButton("AvailForChat");
        JButton joinChatBtn = new JButton("JoinChat");

        // a string array of service list items
        typeOfTaskCombobox = new JComboBox<>(typeOfTask);

        // set one of the options as selected
        typeOfTaskCombobox.setSelectedItem(0);

        // JLabel objects
        menuLabel = new JLabel("| Menu");
        weekDayLabel = new JLabel("Sunday");
        dateLabel = new JLabel("0 | 00 | 0000");
        taskLabel = new JLabel("Tasks");
        titleLabel = new JLabel("Title");
        detailsListLabel = new JLabel("Details");
        liveChatRequestsLabel = new JLabel("LiveChat Request");
        liveChatRequestsTxtLabel = new JLabel("00");

        // labels within the new JPanel - details.
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        middleNameLabel = new JLabel("Middle Name:");
        addressLabel = new JLabel("Address:");
        complaintTimeLabel = new JLabel("Time Lodged:");
        complaintLabel = new JLabel("Complaint:");

        // setting the size of the labels
        microStarLabel.setBounds(10, 0, 350, 50);
        menuLabel.setBounds(150, 0, 350, 50);
        weekDayLabel.setBounds(430, 0, 150, 50);
        dateLabel.setBounds(430, 20, 150, 50);
        taskLabel.setBounds(10, 60, 150, 50);
        typeOfTaskCombobox.setBounds(50, 75, 85, 20);
        titleLabel.setBounds(10, 100, 150, 50);
        complaintList.setBounds(10, 145, 130, 200);
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


        // adding action listener to Respond Button button because it requires an action if
        // it is selected
        respondBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
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
            }
        });
        
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
        this.add(microStarLabel);
        this.add(menuLabel);
        this.add(weekDayLabel);
        this.add(dateLabel);
        this.add(taskLabel);
        this.add(typeOfTaskCombobox);
        this.add(titleLabel);
        this.add(complaintList);
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