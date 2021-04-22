package models.accounts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@MappedSuperclass
public class _Bill implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8129064095859270050L;
    
    /**----------------------------DATA MEMBERS-------------------------------------------- */
    @Id
    @Column(name="bill_id")
    int billID;

    @Column(name="bill_date")
    LocalDate bill_date;

    @Column(name="period_start")
    LocalDate periodStart;

    @Column(name="period_end")
    LocalDate periodEnd;

    @Column(name="amount")
    double amount;

    @Column(name="due_date")
    LocalDate due_date;

    @Column(name="service_id")
    int serviceID;

    
    @Transient
    protected ArrayList<String> validation_errors;

    public boolean validate() {
        boolean valid = true;

        // check if each fields data is valid
        if( (this.periodStart.compareTo(this.periodEnd) > 0)){
            
            this.validation_errors.add("Start date cannot fall after end.");
            valid = false;
        }

        return valid;
    }


    // default constructor
    public _Bill() {
        this.billID = 0;
        this.bill_date = LocalDate.now();
        this.periodStart = null;
        this.periodEnd = null;
        this.amount = 0.0;
        this.due_date = null;
        this.serviceID = 0;
        this.validation_errors = new ArrayList();
    }

    // primary constructor
    public _Bill(int billID, LocalDate date, LocalDate periodStart, LocalDate periodEnd, double amount, LocalDate due, int serviceID) {
        this.billID = billID;
        this.bill_date = date;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.amount = amount;
        this.due_date = due;
        this.serviceID = serviceID;
        this.validation_errors = new ArrayList();
    }

    // copy constructor
    public _Bill(_Bill fee) {
        this.billID = fee.billID;
        this.bill_date = fee.bill_date;
        this.periodStart = fee.periodStart;
        this.periodEnd = fee.periodEnd;
        this.amount = fee.amount;
        this.due_date = fee.due_date;
        this.serviceID = fee.serviceID;
        this.validation_errors = new ArrayList();
    }    

    public int getBillID() {
        return this.billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public LocalDate getDate() {
        return this.bill_date;
    }

    public void setDate(LocalDate date) {
        this.bill_date = date;
    }

    public LocalDate getPeriodStart() {
        return this.periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return this.periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDue() {
        return this.due_date;
    }

    public void setDue(LocalDate due) {
        this.due_date = due;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public ArrayList<String> getValidation_errors() {
        return validation_errors;
    }

    public void setValidation_errors(ArrayList<String> validation_errors) {
        this.validation_errors = validation_errors;
    }

    public _Bill billID(int billID) {
        setBillID(billID);
        return this;
    }

    public _Bill date(LocalDate date) {
        setDate(date);
        return this;
    }

    public _Bill periodStart(LocalDate periodStart) {
        setPeriodStart(periodStart);
        return this;
    }

    public _Bill periodEnd(LocalDate periodEnd) {
        setPeriodEnd(periodEnd);
        return this;
    }

    public _Bill amount(double amount) {
        setAmount(amount);
        return this;
    }

    public _Bill due(LocalDate due) {
        setDue(due);
        return this;
    }

    public _Bill serviceID(int serviceID) {
        setServiceID(serviceID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Bill)) {
            return false;
        }
        _Bill _Bill = (_Bill) o;
        return billID == _Bill.billID && Objects.equals(bill_date, _Bill.bill_date) && Objects.equals(periodStart, _Bill.periodStart) && Objects.equals(periodEnd, _Bill.periodEnd) && amount == _Bill.amount && Objects.equals(due_date, _Bill.due_date) && serviceID == _Bill.serviceID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billID, bill_date, periodStart, periodEnd, amount, due_date, serviceID);
    }

    @Override
    public String toString() {
        return "{" +
            " billID='" + getBillID() + "'" +
            ", date='" + getDate() + "'" +
            ", periodStart='" + getPeriodStart() + "'" +
            ", periodEnd='" + getPeriodEnd() + "'" +
            ", amount='" + getAmount() + "'" +
            ", due='" + getDue() + "'" +
            ", serviceID='" + getServiceID() + "'" +
            "}";
    }

    
}
