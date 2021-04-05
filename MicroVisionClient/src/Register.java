package views.customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField Name_txt_Area;
	private JTextField Email_txt_Area;
	private JTextField Password_txt_Area;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MicroStarLabel = new JLabel("Micro Star Cable Vision");
		MicroStarLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		MicroStarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MicroStarLabel.setBounds(51, 11, 321, 60);
		contentPane.add(MicroStarLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		NameLabel.setBounds(51, 82, 67, 24);
		contentPane.add(NameLabel);
		
		Name_txt_Area = new JTextField();
		Name_txt_Area.setForeground(Color.GRAY);
		Name_txt_Area.setFont(new Font("Tahoma", Font.BOLD, 15));
		Name_txt_Area.setText("Enter your name");
		Name_txt_Area.setBackground(Color.LIGHT_GRAY);
		Name_txt_Area.setBounds(51, 106, 300, 38);
		contentPane.add(Name_txt_Area);
		Name_txt_Area.setColumns(10);
		
		JLabel Email_Label = new JLabel("Email");
		Email_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Email_Label.setBounds(51, 166, 67, 24);
		contentPane.add(Email_Label);
		
		Email_txt_Area = new JTextField();
		Email_txt_Area.setFont(new Font("Tahoma", Font.BOLD, 15));
		Email_txt_Area.setText("Enter your email");
		Email_txt_Area.setForeground(Color.GRAY);
		Email_txt_Area.setBackground(Color.LIGHT_GRAY);
		Email_txt_Area.setBounds(51, 201, 300, 38);
		contentPane.add(Email_txt_Area);
		Email_txt_Area.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(51, 262, 67, 14);
		contentPane.add(PasswordLabel);
		
		Password_txt_Area = new JTextField();
		Password_txt_Area.setText("Enter your passowrd");
		Password_txt_Area.setFont(new Font("Tahoma", Font.BOLD, 15));
		Password_txt_Area.setForeground(Color.GRAY);
		Password_txt_Area.setBackground(Color.LIGHT_GRAY);
		Password_txt_Area.setBounds(51, 288, 300, 38);
		contentPane.add(Password_txt_Area);
		Password_txt_Area.setColumns(10);
		
		JButton RegisterBtn = new JButton("Register");
		RegisterBtn.setBackground(Color.LIGHT_GRAY);
		RegisterBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		RegisterBtn.setForeground(Color.BLACK);
		RegisterBtn.setBounds(51, 349, 300, 38);
		contentPane.add(RegisterBtn);
		
		JLabel Create = new JLabel("Create an Account");
		Create.setBackground(Color.LIGHT_GRAY);
		Create.setForeground(Color.DARK_GRAY);
		Create.setFont(new Font("Tahoma", Font.BOLD, 13));
		Create.setHorizontalAlignment(SwingConstants.CENTER);
		Create.setBounds(10, 416, 122, 14);
		contentPane.add(Create);
		
		Create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Create.addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	System.out.println("Works");
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
		
		JLabel Forgot = new JLabel("Forgot Password");
		Forgot.setHorizontalAlignment(SwingConstants.CENTER);
		Forgot.setForeground(Color.DARK_GRAY);
		Forgot.setFont(new Font("Tahoma", Font.BOLD, 13));
		Forgot.setBackground(Color.LIGHT_GRAY);
		Forgot.setBounds(286, 416, 122, 14);
		contentPane.add(Forgot);
		
		Forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Forgot.addMouseListener(new MouseAdapter() {
			 
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
