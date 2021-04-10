package models.accounts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@MappedSuperclass
public class _Payment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8844351185740139751L;

    @Id
    @Column(name="payment_id")
    int paymentID;

    @Column(name="amount")
    double amount;

    @Column(name="payment_status")
    String paymentStatus;

    @Column(name="payment_date")
    LocalDate paymentDate;

    @Column(name="account_id")
    int accountID;


    @Transient
    protected ArrayList<String> validation_errors;


    public boolean validate() {
        boolean valid = true;

        // check if each fields data is valid
        if( amount <= 0){
            this.validation_errors.add("Invalid payment amount entered.");
            valid = false;
        }
        return valid;
    }

    /**----------------------------CONSTRUCTORS-------------------------------------------- */

    // default constructor
    public _Payment() {
        this.paymentID = 0;
        this.amount = 0;
        this.paymentStatus = "";
        this.paymentDate = LocalDate.now();
        this.accountID = 0;
    }
    
    // primary constructor    
    public _Payment(int paymentID, double amount, String paymentStatus, LocalDate paymentDueDate, int accountID) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDueDate;
        this.accountID = accountID;
    }
    
    // copy constructor    
    public _Payment(_Payment fee) {
        this.paymentID = fee.paymentID;
        this.amount = fee.amount;
        this.paymentStatus = fee.paymentStatus;
        this.paymentDate = fee.paymentDate;
        this.accountID = fee.accountID;
    }

    public int getPaymentID() {
        return this.paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPaymentDueDate() {
        return this.paymentDate;
    }

    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDate = paymentDueDate;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<String> getValidation_errors() {
        return validation_errors;
    }

    public void setValidation_errors(ArrayList<String> validation_errors) {
        this.validation_errors = validation_errors;
    }


    public _Payment paymentID(int paymentID) {
        setPaymentID(paymentID);
        return this;
    }

    public _Payment paymentStatus(String paymentStatus) {
        setPaymentStatus(paymentStatus);
        return this;
    }

    public _Payment paymentDueDate(LocalDate paymentDueDate) {
        setPaymentDueDate(paymentDueDate);
        return this;
    }

    public _Payment accountID(int accountID) {
        setAccountID(accountID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Payment)) {
            return false;
        }
        _Payment _Payment = (_Payment) o;
        return paymentID == _Payment.paymentID && amount == _Payment.amount && Objects.equals(paymentStatus, _Payment.paymentStatus) && Objects.equals(paymentDate, _Payment.paymentDate) && accountID == _Payment.accountID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, amount, paymentStatus, paymentDate, accountID);
    }

    @Override
    public String toString() {
        return "{" +
            " paymentID='" + getPaymentID() + "'" +
            " paymentID='" + getAmount() + "'" +
            ", paymentStatus='" + getPaymentStatus() + "'" +
            ", paymentDueDate='" + getPaymentDueDate() + "'" +
            ", accountID='" + getAccountID() + "'" +
            "}";
    }
    
}
