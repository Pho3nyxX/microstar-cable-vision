package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignIn extends JPanel{

    JTextField usernameTxt;
    JPasswordField passwordTxt;
    JButton loginBtn;
    JButton forgetPasswordBtn;


    public SignIn() {

        JLabel MicroStarLabel = new JLabel("Micro-Star Cable-Vision");
        
        // text fields
        usernameTxt = new JTextField();
        passwordTxt = new JPasswordField();
        loginBtn = new JButton("Login");
        forgetPasswordBtn = new JButton("Forget Password");

        // setting the size of text fields
        MicroStarLabel.setBounds(00, 0, 350, 50);

        MicroStarLabel.setHorizontalAlignment(JLabel.CENTER);

        // setting the sizes of the text fields
        usernameTxt.setBounds(25,50,250,50);
        passwordTxt.setBounds(25,110,250,50);
        loginBtn.setBounds(25,180,250,50);
        forgetPasswordBtn.setBounds(120,260,150,50);

        // adding action listener to Forget Password button because it requires an action if it is selected
        loginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Button clicked");
            }
        });
        
        // adding action listener to Forget Password button because it requires an action if it is selected
        forgetPasswordBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Button clicked");
            }
        });
        
        // adding attributes 
        this.add(MicroStarLabel);
        this.add(usernameTxt);
        this.add(passwordTxt);
        this.add(loginBtn);
        this.add(forgetPasswordBtn);
        
        this.setLayout(null);
        
        // making gui visable
        this.setVisible(true);
    }

    public SignIn(JTextField usernameTxt, JPasswordField passwordTxt, JButton loginBtn, JButton forgetPasswordBtn) {
        this.usernameTxt = usernameTxt;
        this.passwordTxt = passwordTxt;
        this.loginBtn = loginBtn;
        this.forgetPasswordBtn = forgetPasswordBtn;
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
