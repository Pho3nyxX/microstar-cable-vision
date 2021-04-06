package models.accounts;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@MappedSuperclass
public class _Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8513410526093736170L;

    /**----------------------------DATA MEMBERS-------------------------------------------- */
    @Id
    @Column(name="account_id")
    int accountID;

    @Column(name="account_status")
    String accountStatus;

    @Column(name="amount_due")
    double amountDue;

    @Column(name="customer_id")
    int customerID;


    /**----------------------------CONSTRUCTORS-------------------------------------------- */
    //default constructor
    public _Account() {
        this.accountID = 0;
        this.accountStatus = "";
        this.amountDue = 0.0;
        this.customerID = 0;
    }

    // primary constructor
    public _Account(int accountID, String accountStatus, double amountDue, int customerID) {
        this.accountID = accountID;
        this.accountStatus = accountStatus;
        this.amountDue = amountDue;
        this.customerID = customerID;
    }

    // copy constructor
    public _Account(_Account ac) {
        this.accountID = ac.accountID;
        this.accountStatus = ac.accountStatus;
        this.amountDue = ac.amountDue;
        this.customerID = ac.customerID;
    }
        
    /**----------------------------GETTERS/SETTERS-------------------------------------------- */

    public int getAccountID() {
        return this.accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountStatus() {
        return this.accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public double getAmountDue() {
        return this.amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public _Account accountID(int accountID) {
        setAccountID(accountID);
        return this;
    }

    public _Account accountStatus(String accountStatus) {
        setAccountStatus(accountStatus);
        return this;
    }

    public _Account amountDue(double amountDue) {
        setAmountDue(amountDue);
        return this;
    }

    public _Account customerID(int customerID) {
        setCustomerID(customerID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Account)) {
            return false;
        }
        _Account _Account = (_Account) o;
        return accountID == _Account.accountID && Objects.equals(accountStatus, _Account.accountStatus) && amountDue == _Account.amountDue && customerID == _Account.customerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, accountStatus, amountDue, customerID);
    }

    @Override
    public String toString() {
        return "{" +
            " accountID='" + getAccountID() + "'" +
            ", accountStatus='" + getAccountStatus() + "'" +
            ", amountDue='" + getAmountDue() + "'" +
            ", customerID='" + getCustomerID() + "'" +
            "}";
    }
    
}
