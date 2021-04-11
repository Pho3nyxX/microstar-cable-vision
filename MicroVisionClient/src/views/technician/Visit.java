package views.technician;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.View;

public class Visit extends JPanel {

     /** -------------------------MEMBERS------------------------------- */

    //  labels
     JLabel responseLabel;
     JLabel proposedDateOfVisitLabel;
     JLabel proposedTimeOfVisitLabel;
     JLabel microStarLabel;
     JLabel visitLabel;


    // comboboxes
    JComboBox<String> proposedDateOfVisitMonthCombobox;
    JComboBox<String> proposedDateOfVisitDayCombobox;
    JComboBox<String> proposedDateOfVisitYearCombobox;
    JComboBox<String> proposedTimeOfVisitHourCombobox;
    JComboBox<String> proposedTimeOfVisitMinsCombobox;


    // combobox options
    String month[] = { "Jan", "Feb", "Mar", "Apr", "May", }; //TODO:: write code to generate available month
    String day[] = {" 1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; //TODO:: write code to generate available date
    String year[] = { "2021" }; //TODO:: write code to generate available year
    String hour[] = { "1" }; //TODO:: write code to generate available hour
    String mins[] = { "20" }; //TODO:: write code to generate available mins
    

    // inputs
    JButton notifyCustomerBtn;
    JButton submitBtn;
    JButton dashboardBtn;

    /** -------------------------CONSTRUCTORS------------------------------- */

    public Visit() {

        // JLabel objects
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        visitLabel = new JLabel("Proposed Visit Form");


        // JText object
        JTextArea responseTxtArea = new JTextArea();


        // button objects
        notifyCustomerBtn = new JButton("Notify Customer");
        submitBtn = new JButton("Submit");
        dashboardBtn = new JButton("Dashboard");


        // JLabel objects
        responseLabel = new JLabel("Response");
        proposedDateOfVisitLabel = new JLabel("Proposed Date of Visit");
        proposedTimeOfVisitLabel = new JLabel("Proposed Time of Visit");


        // a string array of service list items
        proposedDateOfVisitMonthCombobox = new JComboBox<>(month);
        proposedDateOfVisitDayCombobox = new JComboBox<>(day);
        proposedDateOfVisitYearCombobox = new JComboBox<>(year);
        proposedTimeOfVisitHourCombobox = new JComboBox<>(hour);
        proposedTimeOfVisitMinsCombobox = new JComboBox<>(mins);


        // set one of the options as selected
        proposedDateOfVisitMonthCombobox.setSelectedItem(0);
        proposedDateOfVisitDayCombobox.setSelectedItem(0);
        proposedDateOfVisitYearCombobox.setSelectedItem(0);
        proposedTimeOfVisitHourCombobox.setSelectedItem(0);
        proposedTimeOfVisitMinsCombobox.setSelectedItem(0);


        // setting the size of the labels
        microStarLabel.setBounds(00, 0, 350, 50);
        visitLabel.setBounds(50, 30, 250, 50);
        responseLabel.setBounds(10, 100, 150, 20);
        proposedDateOfVisitLabel.setBounds(10, 160, 150, 20);
        proposedTimeOfVisitLabel.setBounds(10, 220, 150, 20);


         // setting the size of text field sizes
         responseTxtArea.setBounds(170, 90, 200, 40);
         proposedDateOfVisitMonthCombobox.setBounds(170, 150, 50, 40);
         proposedDateOfVisitDayCombobox.setBounds(240, 150, 50, 40);
         proposedDateOfVisitYearCombobox.setBounds(310, 150, 60, 40);
         proposedTimeOfVisitHourCombobox.setBounds(170, 210, 50, 40);
         proposedTimeOfVisitMinsCombobox.setBounds(240, 210, 50, 40);

         notifyCustomerBtn.setBounds(10, 270, 140, 40);
         submitBtn.setBounds(170, 270, 80, 40);
         dashboardBtn.setBounds(270, 270, 100, 40);


        // adding action listener to Notify Customer button button because it requires an action if it is selected
        notifyCustomerBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Button clicked");
            }
        });


        // adding action listener to Submit Button button because it requires an action if it is selected
        submitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Button clicked");
            }
        });
        

        // adding action listener to Dashboard button because it requires an action if it is selected
        dashboardBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Button clicked");
            }
        });


        // centering Micro-Star Cable-Vision and Complaint Form
        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        visitLabel.setHorizontalAlignment(JLabel.CENTER);


         // adding attributes
        this.add(microStarLabel);
        this.add(visitLabel);
        this.add(responseLabel);
        this.add(responseTxtArea);
        this.add(proposedDateOfVisitLabel);
        this.add(proposedDateOfVisitMonthCombobox);
        this.add(proposedDateOfVisitDayCombobox);
        this.add(proposedDateOfVisitYearCombobox);
        this.add(proposedTimeOfVisitLabel);
        this.add(proposedTimeOfVisitHourCombobox);
        this.add(proposedTimeOfVisitMinsCombobox);
        this.add(notifyCustomerBtn);
        this.add(submitBtn);
        this.add(dashboardBtn);


        
        this.setLayout(null);

        // making GUI visable
        this.setVisible(true);




    }
    
}
