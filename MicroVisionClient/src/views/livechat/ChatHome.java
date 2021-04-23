package views.livechat;

import controllers.LiveChat;
import driver.Driver;
import models.complaints.Complaint;
import models.users.Customer;
import models.users.Employee;
import models.users._User;
import utilities.ServerRequest;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatHome extends JFrame {
    
    JLabel nameOfClientLabel;
    JLabel doToHelpLabel;
    JLabel startAConversationLabel;
    JLabel profileImageLabel;
    public static JTextArea personsOnlineTextArea;
    JButton newConversationButton;
    JButton logOffButton;
    JPanel mainPanel;
    JPanel topPanel;
    JPanel middleActiveClientsPanel;
    Border blueLine;
    Border raisedBevel;
    Border compoundActiveClientsBorder;
    Color blueBackground;


    public ChatHome () {

        blueBackground = new Color(41,193,239);

        profileImageLabel = new JLabel(new ImageIcon("image/Chat.png"));
        nameOfClientLabel = new JLabel("Hi, " + Driver.CURRENT_USER.getfirstName() + "!");
        doToHelpLabel = new JLabel("What can we do to help?");
        startAConversationLabel = new JLabel("Start a Conversation");

        topPanel = new JPanel();
        middleActiveClientsPanel = new JPanel();
        mainPanel = new JPanel();

        personsOnlineTextArea = new JTextArea();

        newConversationButton = new JButton("New Conversation");
        logOffButton = new JButton("Log Off");

        blueLine = BorderFactory.createLineBorder(blueBackground);
        raisedBevel = BorderFactory.createRaisedBevelBorder();
        compoundActiveClientsBorder = BorderFactory.createCompoundBorder(blueLine,raisedBevel);

        topPanel.setLayout(null);
        middleActiveClientsPanel.setLayout(null);

        topPanel.setBackground(blueBackground);
        newConversationButton.setBackground(blueBackground);
        logOffButton.setBackground(blueBackground);

        nameOfClientLabel.setForeground(Color.WHITE);
        doToHelpLabel.setForeground(Color.WHITE);
        newConversationButton.setForeground(Color.WHITE);
        logOffButton.setForeground(Color.WHITE);

        middleActiveClientsPanel.setBorder(compoundActiveClientsBorder);

        nameOfClientLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        doToHelpLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
        startAConversationLabel.setFont(new Font("Tahoma", Font.PLAIN,20));
        personsOnlineTextArea.setFont(new Font("Tahoma",Font.PLAIN,20));

        topPanel.setBounds(0,0,450,170);
        middleActiveClientsPanel.setBounds(5,180,425,300);
        profileImageLabel.setBounds(70,40,60,60);
        nameOfClientLabel.setBounds(75,90,400,40);
        doToHelpLabel.setBounds(90,120,400,40);
        startAConversationLabel.setBounds(110,5,200,30);
        personsOnlineTextArea.setBounds(10,40,400,250);
        newConversationButton.setBounds(10,500,200,50);
        logOffButton.setBounds(230,500,200,50);

        personsOnlineTextArea.setEditable(false);

        topPanel.add(profileImageLabel);
        topPanel.add(nameOfClientLabel);
        topPanel.add(doToHelpLabel);

        middleActiveClientsPanel.add(startAConversationLabel);
        middleActiveClientsPanel.add(personsOnlineTextArea);

        mainPanel.add(topPanel);
        mainPanel.add(middleActiveClientsPanel);
        mainPanel.add(newConversationButton);
        mainPanel.add(logOffButton);

        mainPanel.setLayout(null);
        mainPanel.setSize(450, 600);
        mainPanel.setVisible(true);

        this.setSize(450,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(mainPanel);
        this.setVisible(true);

        //To show in the test area the Technicians or Customers that are online
        LiveChat.logOnToLiveChat(Driver.CURRENT_USER);
        //Live chat will then update the text area based on the response from the Sever

        newConversationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "Enter name");

                if (name == null) {
                    JOptionPane.showMessageDialog(null,"Name empty","Error",
                            JOptionPane.WARNING_MESSAGE);
                }else {
                    _User recipientUser = LiveChat.findUserFromUsername(name);
                    //Get complaints to be displayed so a choice can be made
                    if (Driver.SESSION_TYPE.equals("Customer")) {
                        LiveChat.loadUserComplaints(Driver.CURRENT_USER);
                    }else if (Driver.SESSION_TYPE.equals("Employee")) {
                        LiveChat.loadUserComplaints(recipientUser);
                    }

                    String complaintId = JOptionPane.showInputDialog(null,"Enter complaint id");

                    if (complaintId == null) {
                        JOptionPane.showMessageDialog(null,"Complaint id empty","Error",
                                JOptionPane.WARNING_MESSAGE);
                    }else {
                        Complaint complaint = LiveChat.findComplaintFromId(Integer.parseInt(complaintId));

                        //Call the Chat message constructer
                        Driver.FRAME.add(new ChatMessage(recipientUser, complaint));
                    }
                }
            }
        });

        logOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LiveChat.logOffLiveChat(Driver.CURRENT_USER);
            }
        });
    }
}
