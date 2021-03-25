package models.accounts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// Annotations
@Entity
@Table(name = "payment")
public class _Payment implements Serializable {

    @Column(name="payment_id")
    int paymentID;

    @Column(name="payment_status")
    String paymentStatus;

    @Column(name="payment_due_date")
    LocalDate paymentDueDate;

    @Column(name="account_id")
    int accountID;

    // default constructor
    public _Payment() {
        this.paymentID = 0;
        this.paymentStatus = "";
        this.paymentDueDate = LocalDate.now();
        this.accountID = 0;
    }

    // primary constructor    
    public _Payment(int paymentID, String paymentStatus, LocalDate paymentDueDate, int accountID) {
        this.paymentID = paymentID;
        this.paymentStatus = paymentStatus;
        this.paymentDueDate = paymentDueDate;
        this.accountID = accountID;
    }

    // copy constructor    
    public _Payment(_Payment fee) {
        this.paymentID = fee.paymentID;
        this.paymentStatus = fee.paymentStatus;
        this.paymentDueDate = fee.paymentDueDate;
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
        return this.paymentDueDate;
    }

    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
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
        return paymentID == _Payment.paymentID && Objects.equals(paymentStatus, _Payment.paymentStatus) && Objects.equals(paymentDueDate, _Payment.paymentDueDate) && accountID == _Payment.accountID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, paymentStatus, paymentDueDate, accountID);
    }

    @Override
    public String toString() {
        return "{" +
            " paymentID='" + getPaymentID() + "'" +
            ", paymentStatus='" + getPaymentStatus() + "'" +
            ", paymentDueDate='" + getPaymentDueDate() + "'" +
            ", accountID='" + getAccountID() + "'" +
            "}";
    }

    
}
