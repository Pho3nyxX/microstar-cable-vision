package views.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Password extends JPanel{

    JTextField codetxt;
    JTextField emailTxt;
    JPasswordField passwordTxt;
    JButton submitBtn;
    JButton backToLoginBtn;

    public Password() {

        JLabel MicroStarLabel = new JLabel("Micro-Star Cable-Vision");

        // text fields
        codetxt = new JTextField();
        emailTxt = new JTextField();
        passwordTxt = new JPasswordField();
        submitBtn = new JButton("Submit");
        backToLoginBtn = new JButton("Back to login");
        
        // centering Micro-Star Cable-Vision
        MicroStarLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // setting the size of MicroStarLabel 
        MicroStarLabel.setBounds(00, 0, 350, 50);

        // setting the size of the text fields
        codetxt.setBounds(25,50,250,50);
        emailTxt.setBounds(25,110,250,50);
        passwordTxt.setBounds(25,170,250,50);
        submitBtn.setBounds(25,230,250,50);
        backToLoginBtn.setBounds(120,290,150,50);
       
       // adding action listener to Forget Password button because it requires an action if it is selected
       backToLoginBtn.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               System.out.println("Button clicked");
           }
       });

        // adding attributes 
        this.add(MicroStarLabel);
        this.add(codetxt);
        this.add(emailTxt);
        this.add(passwordTxt);
        this.add(submitBtn);
        this.add(backToLoginBtn);
        
        this.setLayout(null);
        
        // making GUI visable
        this.setVisible(true);

    }

    public Password(JTextField codetxt, JTextField emailTxt, JPasswordField passwordTxt, JButton submitBtn, JButton backToLoginBtn) {
        this.codetxt = codetxt;
        this.emailTxt = emailTxt;
        this.passwordTxt = passwordTxt;
        this.submitBtn = submitBtn;
        this.backToLoginBtn = backToLoginBtn;
    }

    public JTextField getCodetxt() {
        return this.codetxt;
    }

    public void setCodetxt(JTextField codetxt) {
        this.codetxt = codetxt;
    }

    public JTextField getEmailTxt() {
        return this.emailTxt;
    }

    public void setEmailTxt(JTextField emailTxt) {
        this.emailTxt = emailTxt;
    }

    public JPasswordField getPasswordTxt() {
        return this.passwordTxt;
    }

    public void setPasswordTxt(JPasswordField passwordTxt) {
        this.passwordTxt = passwordTxt;
    }

    public JButton getSubmitBtn() {
        return this.submitBtn;
    }

    public void setSubmitBtn(JButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public JButton getBackToLoginBtn() {
        return this.backToLoginBtn;
    }

    public void setBackToLoginBtn(JButton backToLoginBtn) {
        this.backToLoginBtn = backToLoginBtn;
    }

    public Password codetxt(JTextField codetxt) {
        setCodetxt(codetxt);
        return this;
    }

    public Password emailTxt(JTextField emailTxt) {
        setEmailTxt(emailTxt);
        return this;
    }

    public Password passwordTxt(JPasswordField passwordTxt) {
        setPasswordTxt(passwordTxt);
        return this;
    }

    public Password submitBtn(JButton submitBtn) {
        setSubmitBtn(submitBtn);
        return this;
    }

    public Password backToLoginBtn(JButton backToLoginBtn) {
        setBackToLoginBtn(backToLoginBtn);
        return this;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Password)) {
            return false;
        }
        Password password = (Password) o;
        return Objects.equals(codetxt, password.codetxt) && Objects.equals(emailTxt, password.emailTxt) && Objects.equals(passwordTxt, password.passwordTxt) && Objects.equals(submitBtn, password.submitBtn) && Objects.equals(backToLoginBtn, password.backToLoginBtn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codetxt, emailTxt, passwordTxt, submitBtn, backToLoginBtn);
    }
*/

    @Override
    public String toString() {
        return "{" +
            " codetxt='" + getCodetxt() + "'" +
            ", emailTxt='" + getEmailTxt() + "'" +
            ", passwordTxt='" + getPasswordTxt() + "'" +
            ", submitBtn='" + getSubmitBtn() + "'" +
            ", backToLoginBtn='" + getBackToLoginBtn() + "'" +
            "}";
    }

    
}
