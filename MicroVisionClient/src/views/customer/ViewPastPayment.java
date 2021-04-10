package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ViewPastPayment extends JPanel {

    /** -------------------------MEMBERS------------------------------- */

    // labels
    JLabel microStarLabel;
    JLabel paymentsHeaderLabel;
    JLabel monthLabel;
    JLabel paymentMonthsLabel;
    JLabel paymentsListLabel;
    JLabel detailsLabel;

    JLabel accountNumberLabel;
    JLabel methodOfPaymentLabel;
    JLabel dateLabel;
    JLabel amountLabel;

    // JList
    JList<String> paymentList;

    JScrollPane paymentListScroller;
    JScrollPane detailsListScroller;

    // Panel for the details of the complaint
    JPanel detailsPanel;

    // comboboxes
    JComboBox<String> paymentMonthsCombobox;

    // combobox options
    String paymentMonths[] = { "None", "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };

    // button
    JButton dashboardBtn;

    /** -------------------------CONSTRUCTORS------------------------------- */

    public ViewPastPayment() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        paymentsHeaderLabel = new JLabel("Past Payments");
        monthLabel = new JLabel("Months");
        paymentsListLabel = new JLabel("Payments");
        detailsLabel = new JLabel("Details");

        // labels within the new JPanel - details.
        accountNumberLabel = new JLabel("Account Number:");
        methodOfPaymentLabel = new JLabel("Payment Method:");
        dateLabel = new JLabel("Date Paid:");
        amountLabel = new JLabel("Amount Paid:");

        // JLists
        String[] data = { "Payment1", "Payment2", "Payment3", "Payment4", "Payment5", "Payment6", "Payment7",
                "Payment8", "Payment9", "Payment10" };
        paymentList = new JList<String>(data);

        paymentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        paymentList.setLayoutOrientation(JList.VERTICAL);

        // add the jlist to the jscrollpane
        paymentListScroller = new JScrollPane(paymentList);

        // JPanel object
        detailsPanel = new JPanel();

        // button objects
        dashboardBtn = new JButton("Dashboard");

        // a string array of service list items
        paymentMonthsCombobox = new JComboBox<>(paymentMonths);

        // set one of the options as selected
        paymentMonthsCombobox.setSelectedItem(0);

        // setting the size of the labels
        microStarLabel.setBounds(00, 0, 350, 50);
        paymentsHeaderLabel.setBounds(50, 30, 250, 50);
        monthLabel.setBounds(10, 80, 150, 50);
        paymentMonthsCombobox.setBounds(60, 90, 90, 30);
        paymentsListLabel.setBounds(10, 130, 90, 30);
        paymentList.setBounds(10, 170, 130, 200);
        detailsLabel.setBounds(300, 115, 130, 50);

        // bounds being set on labels within the new JPanel - details.
        detailsPanel.setBounds(300, 145, 130, 200);
        accountNumberLabel.setBounds(0, 20, 110, 20);
        methodOfPaymentLabel.setBounds(0, 60, 110, 20);
        dateLabel.setBounds(0, 100, 120, 20);
        amountLabel.setBounds(0, 140, 110, 20);

        // setting bounds on buttons
        dashboardBtn.setBounds(300, 350, 105, 30);

        // adding action listener to Dashboard Button button because it requires an
        // action if
        // it is selected
        dashboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // adding items to details panel
        detailsPanel.add(accountNumberLabel);
        detailsPanel.add(methodOfPaymentLabel);
        detailsPanel.add(dateLabel);
        detailsPanel.add(amountLabel);

        detailsPanel.setLayout(null);

        // items being added to the new JPanel window
        this.add(detailsPanel);

        // centering Micro-Star Cable-Vision and Register
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        paymentsHeaderLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding attributes
        this.add(microStarLabel);
        this.add(paymentsHeaderLabel);
        this.add(monthLabel);
        this.add(paymentMonthsCombobox);
        this.add(paymentsListLabel);
        this.add(paymentList);
        this.add(detailsLabel);
        this.add(dashboardBtn);

        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);

    }

}
