package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Complaint extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

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

    // JTextArea
    JTextArea complaintTxtArea;

    // JButton
    JButton dashboardBtn;

    public Complaint() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        complaintHeaderLabel = new JLabel("Complaint");

        // button objects
        JButton DashboardBtn = new JButton("Dashboard");

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

        DashboardBtn.setBounds(50, 340, 98, 30);

        // adding action listener to Save Button button because it requires an action if
        // it is selected
        DashboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // centering Micro-Star Cable-Vision and Register
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        complaintHeaderLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        this.add(microStarLabel);
        this.add(complaintHeaderLabel);
        this.add(titleLabel);
        this.add(titleTxtField);
        this.add(dateMadeLabel);
        this.add(dateMadeTxtField);
        this.add(complaintLabel);
        this.add(complaintTxtField);
        this.add(reponseDateLabel);
        this.add(responseDateTxtField);
        this.add(respondeeLabel);
        this.add(respondeeTxtField);
        this.add(reponseLabel);
        this.add(responseTxtField);
        this.add(DashboardBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

}
