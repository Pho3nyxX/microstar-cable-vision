package views.livechat;

import controllers.LiveChat;
import driver.Driver;
import javazoom.jl.decoder.JavaLayerException;
import models.chat.Message;
import models.chat._Message;
import models.complaints.Complaint;
import models.users._User;
import sound.Mp3;
import utilities.ServerRequest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ChatMessage extends JPanel{
    JLabel backArrowImageLabel;
    JLabel profileImageLabel;
    JLabel nameLabel;
    JLabel availableLabel;
    JTextField typeMessageTextField;
    JButton sendMessageButton;
    JPanel topPanel;
    Boolean typing;
    static JPanel chatAreaPanel;
    static JScrollPane chatAreaScrollPane;
    static Box verticalBox = Box.createVerticalBox();
    ScrollBarUI scrollBarUI;

    static int messageID = 0;

    ChatMessage(_User recipient, Complaint complaint) {
        backArrowImageLabel = new JLabel(new ImageIcon("image/BackArrow.png"));
        profileImageLabel = new JLabel(new ImageIcon("image/Chat.png"));
        nameLabel = new JLabel(recipient.getUsername());
        availableLabel = new JLabel("Active Now");
        typeMessageTextField = new JTextField();
        sendMessageButton = new JButton("Send");
        chatAreaPanel = new JPanel();
        chatAreaScrollPane = new JScrollPane(chatAreaPanel);

        nameLabel.setFont(new Font("Dialog",Font.BOLD, 30));
        availableLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        typeMessageTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sendMessageButton.setFont(new Font("Times New Roman",Font.PLAIN,16));
        chatAreaPanel.setFont(new Font ("Times New Roman", Font.PLAIN,16));

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
        chatAreaScrollPane.setBounds(0,70,450,458);

        scrollBarUI = new BasicScrollBarUI() {
            protected JButton createDecreaseButton(int orientation) {
                JButton jButton = super.createDecreaseButton(orientation);
                jButton.setBackground(new Color(41,193,239));
                jButton.setForeground(Color.WHITE);
                this.thumbColor = new Color(41,193,239);
                return jButton;
            }

            protected JButton createIncreaseButton(int orientation) {
                JButton jButton = super.createIncreaseButton(orientation);
                jButton.setBackground(new Color(41,193,239));
                jButton.setForeground(Color.WHITE);
                this.thumbColor = new Color(41,193,239);
                return jButton;
            }
        };

        chatAreaScrollPane.setBorder(BorderFactory.createEmptyBorder());
        chatAreaScrollPane.getVerticalScrollBar().setUI(scrollBarUI);

        typing=false;

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!typing) {
                    availableLabel.setText("Active Now");
                }
            }
        });

        timer.setInitialDelay(2000);

        typeMessageTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                availableLabel.setText("Typing...");
                timer.stop();
                typing=true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                typing=false;
                if (!timer.isRunning()) {
                    timer.start();
                }
            }
        });

        backArrowImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Go back to the chat home panel
                Driver.FRAME.add(new ChatHome());
            }
        });

        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String messageToBeSent = typeMessageTextField.getText();
                JPanel setRightPanel = new JPanel(new BorderLayout());
                chatAreaPanel.setLayout(new BorderLayout());
                JPanel outputFromFormatPanel = formatLabel(messageToBeSent);

                setRightPanel.add(outputFromFormatPanel,BorderLayout.LINE_END);
                verticalBox.add(setRightPanel);
                verticalBox.add(Box.createVerticalStrut(10));
                chatAreaPanel.add(verticalBox,BorderLayout.PAGE_START);

                LiveChat.sendMessage(new Message(messageID+1,messageToBeSent,false, LocalDateTime.now(),
                        recipient.getUserID(), Driver.CURRENT_USER.getUserID(), complaint.getComplaintId()));
                typeMessageTextField.setText("");

                receiveResponse(LiveChat.receiveMessage());
            }
        });

        topPanel.add(backArrowImageLabel);
        topPanel.add(profileImageLabel);
        topPanel.add(nameLabel);
        topPanel.add(availableLabel);
        this.add(topPanel);
        //this.add(chatAreaPanel);
        this.add(chatAreaScrollPane);
        this.add(typeMessageTextField);
        this.add(sendMessageButton);

        this.setLayout(null);
        this.setSize(450, 600);
        this.setVisible(true);
    }

    public static JPanel formatLabel(String outPutMessage) {
        JPanel outputTextPanel = new JPanel();
        JLabel outputTextLabel = new JLabel("<html><p style = \"width : 150px\">" + outPutMessage +"</p></html>");
        JLabel timeStampLabel = new JLabel();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        outputTextPanel.setLayout(new BoxLayout(outputTextPanel,BoxLayout.Y_AXIS));

        outputTextLabel.setFont(new Font("Tahoma", Font.PLAIN,16));
        outputTextLabel.setBackground(new Color(51,141,230));
        outputTextLabel.setOpaque(true);
        outputTextLabel.setBorder(new EmptyBorder(15,15,15,50));

        timeStampLabel.setText(dateFormat.format(calendar.getTime()));

        outputTextPanel.add(outputTextLabel);
        outputTextPanel.add(timeStampLabel);
        return outputTextPanel;
    }

    public void receiveResponse(_Message message) {
        //Would output the message to the GUI
        JPanel incomingMessagePanel = formatLabel(message.getText());
        JPanel setLeftPanel = new JPanel(new BorderLayout());

        setLeftPanel.add(incomingMessagePanel,BorderLayout.LINE_START);
        verticalBox.add(setLeftPanel);
        this.validate();

        try {
            Mp3.playMp3("1");
        }catch (JavaLayerException ex) {
            System.out.println("Error message to be logged");
        }
        JOptionPane.showMessageDialog(null,"1 New Message","New Messages",
                JOptionPane.INFORMATION_MESSAGE);

        message.setRead(true);
    }
}
