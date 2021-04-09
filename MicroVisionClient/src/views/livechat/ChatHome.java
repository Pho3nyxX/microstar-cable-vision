package views.livechat;

import javax.swing.*;

public class ChatHome extends JPanel{
    JLabel onlineChatsLabel;
    JTextArea personsOnlineTextArea;
    JButton logOn;
    JButton logOff;


    ChatHome () {

        this.setLayout(null);
        this.setSize(500, 600);
        this.setVisible(true);
    }
}
