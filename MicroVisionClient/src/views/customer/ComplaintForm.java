package views.customer;

import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.EventQueue;

public class ComplaintForm extends JFrame {

	private JPanel contentPane;
	private JLabel type_of_complaint_label;

	/**
	 * Create the frame.
	 */
	public ComplaintForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\18764\\Downloads\\starlogo.jpg"));
		setTitle("Micro Star Vision");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel FormLabel = new JLabel("Complaint Form");
		FormLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		FormLabel.setBounds(5, 5, 450, 16);
		FormLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(FormLabel);
		
		type_of_complaint_label = new JLabel("Type of Complaint");
		type_of_complaint_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		type_of_complaint_label.setBounds(15, 44, 119, 27);
		contentPane.add(type_of_complaint_label);
		
		JComboBox type_of_complaint_combobox = new JComboBox();
		type_of_complaint_combobox.setModel(new DefaultComboBoxModel(new String[] {"Internet", "Phone", "Television"}));
		type_of_complaint_combobox.setMaximumRowCount(3);
		type_of_complaint_combobox.setBounds(152, 45, 285, 25);
		contentPane.add(type_of_complaint_combobox);
		
		JLabel complaint_label = new JLabel("Complaint");
		complaint_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		complaint_label.setBounds(15, 125, 88, 27);
		contentPane.add(complaint_label);
		
		JTextArea complaint_textarea = new JTextArea();
		complaint_textarea.setBounds(121, 100, 327, 93);
		contentPane.add(complaint_textarea);
		
		JComboBox contact_method_combobox = new JComboBox();
		contact_method_combobox.setModel(new DefaultComboBoxModel(new String[] {"Phone ", "Email"}));
		contact_method_combobox.setMaximumRowCount(2);
		contact_method_combobox.setBounds(152, 213, 285, 25);
		contentPane.add(contact_method_combobox);
		
		JLabel contact_method_label = new JLabel("Contact Method");
		contact_method_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		contact_method_label.setBounds(12, 217, 110, 16);
		contentPane.add(contact_method_label);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(185, 264, 98, 26);
		contentPane.add(submitBtn);
		
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Button was clicked");
				System.out.println("Button was clicked");
				System.out.println("Button was clicked");
			}
			
		});
	}
}
