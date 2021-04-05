package views.customer;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class IfSave extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IfSave frame = new IfSave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IfSave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ThankYou_Label = new JLabel("Thank you for logging your complaint. We will respond to you ");
		ThankYou_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		ThankYou_Label.setHorizontalAlignment(SwingConstants.CENTER);
		ThankYou_Label.setBounds(10, 23, 543, 61);
		contentPane.add(ThankYou_Label);
		
		JLabel Asap_Label = new JLabel("as soon as possible.");
		Asap_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Asap_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Asap_Label.setBounds(215, 81, 141, 23);
		contentPane.add(Asap_Label);
		
		JLabel ViewComplaintLabel = new JLabel("View Complaint");
		ViewComplaintLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ViewComplaintLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ViewComplaintLabel.setBounds(111, 197, 116, 23);
		contentPane.add(ViewComplaintLabel);
		
		ViewComplaintLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ViewComplaintLabel.addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	System.out.println("Forgot button works");
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        // the mouse has entered the label
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		        // the mouse has exited the label
		    }
		});
		
		JLabel DashboardLabel = new JLabel("Return to Dashboard");
		DashboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DashboardLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		DashboardLabel.setBounds(335, 197, 146, 23);
		contentPane.add(DashboardLabel);
		
		DashboardLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DashboardLabel.addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	System.out.println("Forgot button works");
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        // the mouse has entered the label
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		        // the mouse has exited the label
		    }
		});
	}
}
