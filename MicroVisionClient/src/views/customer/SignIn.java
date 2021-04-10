package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.Authentication;

public class SignIn extends JDialog{

    JTextField usernameTxt;
    JPasswordField passwordTxt;
    JButton loginBtn;
    JButton forgetPasswordBtn;
    JPanel contentPanel;
    JLabel loginErrorLabel;
    JLabel microStarLabel;

    /*----------------------CONSTRUCTORS-----------------------------*/

    public SignIn(Frame parent) {

        super(parent, "Sign in", true);

        contentPanel = new JPanel();
        microStarLabel = new JLabel("Micro-Star Cable-Vision");
        loginErrorLabel = new JLabel("Login failed");
        
        // text fields
        usernameTxt = new JTextField();
        passwordTxt = new JPasswordField();
        loginBtn = new JButton("Login");
        forgetPasswordBtn = new JButton("Forget Password");

        // setting the size of text fields
        microStarLabel.setBounds(0, 0, 315, 50);
        loginErrorLabel.setBounds(0, 155, 315, 50);

        microStarLabel.setHorizontalAlignment(JLabel.CENTER);
        loginErrorLabel.setHorizontalAlignment(JLabel.CENTER);
        loginErrorLabel.setForeground(Color.RED);
        loginErrorLabel.setVisible(false);

        // setting the sizes of the text fields
        usernameTxt.setBounds(25,50,250,50);
        passwordTxt.setBounds(25,120,250,50);
        loginBtn.setBounds(25,200,250,50);
        forgetPasswordBtn.setBounds(150,260,140,25);
        forgetPasswordBtn.setBorderPainted(false);
        forgetPasswordBtn.setContentAreaFilled(false);

        // adding action listener to button because it requires an action if it is selected
        loginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // System.out.println("Button clicked");
                Authentication auth =  new Authentication();
                String password;
                String userName;
                boolean loggedIn = false;

                password = new String(passwordTxt.getPassword());
                userName = usernameTxt.getText();
                
                
                if (userName.isBlank() || password.isBlank()) {
                    
                    loginErrorLabel.setText("Username and Password cannot be blank.");
                    
                    loginErrorLabel.setVisible(true);
                    
                } else {
                    
                    loggedIn = auth.login(userName, password);
                    
                    if (loggedIn) {

                        dispose();

                    } else {

                        loginErrorLabel.setText("Login failed!");
                        loginErrorLabel.setVisible(true);;
                    }
                }
            }
        });
        
        // adding action listener to Forget Password button because it requires an action if it is selected
        forgetPasswordBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Button clicked");
            }
        });
        contentPanel.setBounds(0,0,300,300);
        
        // adding attributes 
        contentPanel.add(microStarLabel);
        contentPanel.add(loginErrorLabel);
        contentPanel.add(usernameTxt);
        contentPanel.add(passwordTxt);
        contentPanel.add(loginBtn);
        contentPanel.add(forgetPasswordBtn);
        
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        this.add(contentPanel);
        this.setSize(315,400);
        contentPanel.setLayout(null);
        
        // making gui visable'
        // this.setResizable(false);
        this.setLocationRelativeTo(parent);
        // this.pack();
        this.setVisible(true);
    }



    public JTextField getUsernameTxt() {
        return this.usernameTxt;
    }

    public void setUsernameTxt(JTextField usernameTxt) {
        this.usernameTxt = usernameTxt;
    }

    public JPasswordField getPasswordTxt() {
        return this.passwordTxt;
    }

    public void setPasswordTxt(JPasswordField passwordTxt) {
        this.passwordTxt = passwordTxt;
    }

    public JButton getLoginBtn() {
        return this.loginBtn;
    }

    public void setLoginBtn(JButton loginBtn) {
        this.loginBtn = loginBtn;
    }

    public JButton getForgetPasswordBtn() {
        return this.forgetPasswordBtn;
    }

    public void setForgetPasswordBtn(JButton forgetPasswordBtn) {
        this.forgetPasswordBtn = forgetPasswordBtn;
    }

    public SignIn usernameTxt(JTextField usernameTxt) {
        setUsernameTxt(usernameTxt);
        return this;
    }

    public SignIn passwordTxt(JPasswordField passwordTxt) {
        setPasswordTxt(passwordTxt);
        return this;
    }

    public SignIn loginBtn(JButton loginBtn) {
        setLoginBtn(loginBtn);
        return this;
    }

    public SignIn forgetPasswordBtn(JButton forgetPasswordBtn) {
        setForgetPasswordBtn(forgetPasswordBtn);
        return this;
    }

/*    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SignIn)) {
            return false;
        }
        SignIn signIn = (SignIn) o;
        return Objects.equals(usernameTxt, signIn.usernameTxt) && Objects.equals(passwordTxt, signIn.passwordTxt) && Objects.equals(loginBtn, signIn.loginBtn) && Objects.equals(forgetPasswordBtn, signIn.forgetPasswordBtn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usernameTxt, passwordTxt, loginBtn, forgetPasswordBtn);
    }
*/
    @Override
    public String toString() {
        return "{" +
            " usernameTxt='" + getUsernameTxt() + "'" +
            ", passwordTxt='" + getPasswordTxt() + "'" +
            ", loginBtn='" + getLoginBtn() + "'" +
            ", forgetPasswordBtn='" + getForgetPasswordBtn() + "'" +
            "}";
    }

}
