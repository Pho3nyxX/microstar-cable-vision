package views.livechat;

import controllers.LiveChat;
import driver.Driver;
import models.chat.Message;
import models.complaints.Complaint;
import models.users._User;
import utilities.ServerRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

public class ChatMessage extends JPanel{
    JLabel backArrowImageLabel;
    JLabel profileImageLabel;
    JLabel nameLabel;
    JLabel availableLabel;
    JTextField typeMessageTextField;
    JButton sendMessageButton;
    JPanel topPanel;
    public static JTextArea chatTextArea;

    static int messageID = 0;

    ChatMessage(_User recipient, Complaint complaint) {
        backArrowImageLabel = new JLabel(new ImageIcon("image/BackArrow.png"));
        profileImageLabel = new JLabel(new ImageIcon("image/Chat.png"));
        nameLabel = new JLabel(recipient.getUsername());
        availableLabel = new JLabel("Active Now");
        typeMessageTextField = new JTextField();
        sendMessageButton = new JButton("Send");
        chatTextArea = new JTextArea();

        nameLabel.setFont(new Font("Dialog",Font.BOLD, 30));
        availableLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        typeMessageTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sendMessageButton.setFont(new Font("Times New Roman",Font.PLAIN,16));
        chatTextArea.setFont(new Font ("Times New Roman", Font.PLAIN,16));

        chatTextArea.setEditable(false);
        chatTextArea.setLineWrap(true);
        chatTextArea.setWrapStyleWord(true);

        nameLabel.setForeground(Color.WHITE);
        availableLabel.setForeground(Color.WHITE);
        sendMessageButton.setForeground(Color.WHITE);
        sendMessageButton.setBackground(new Color(41,193,239));

        topPanel = new JPanel();

        topPanel.setLayout(null);
        topPanel.setBackground(new Color(41,193,239));
        topPanel.setBounds(0,0,450,70);

        backArrowImageLabel.setBounds(20,4,60,60);
        profileImageLabel.setBounds(90,7,60,60);
        nameLabel.setBounds(150,9,300,40);
        availableLabel.setBounds(210,35,300,40);
        typeMessageTextField.setBounds(1,532,315,30);
        sendMessageButton.setBounds(318,532,115,30);
        chatTextArea.setBounds(0,70,450,458);


        backArrowImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Go back to the chat home panel
            }
        });

        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String messageToBeSent = typeMessageTextField.getText();
                chatTextArea.setText(chatTextArea.getText() + " \n\t\t" + messageToBeSent);
                //To Do Set a colour for the message to be sent
                LiveChat.sendMessage(new Message(messageID+1,messageToBeSent,false, LocalDateTime.now(),
                        recipient.getUserID(), Driver.CURRENT_USER.getUserID(), complaint.getComplaintId()));
                typeMessageTextField.setText("");
            }
        });

        topPanel.add(backArrowImageLabel);
        topPanel.add(profileImageLabel);
        topPanel.add(nameLabel);
        topPanel.add(availableLabel);
        this.add(topPanel);
        this.add(chatTextArea);
        this.add(typeMessageTextField);
        this.add(sendMessageButton);

        this.setLayout(null);
        this.setSize(450, 600);
        this.setVisible(true);
    }
}
