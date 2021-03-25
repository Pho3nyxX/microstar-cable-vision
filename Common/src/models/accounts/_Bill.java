package models.accounts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// Annotations
@Entity
@Table(name = "bill")
public class _Bill implements Serializable {

    @Column(name="bill_id")
    int billID;

    @Column(name="date")
    LocalDate date;

    @Column(name="period_start")
    LocalDate periodStart;

    @Column(name="period_end")
    LocalDate periodEnd;

    @Column(name="amount")
    double amount;

    @Column(name="due")
    LocalDate due;

    @Column(name="serive_id")
    int serviceID;

    // default constructor
    public _Bill() {
        this.billID = 0;
        this.date = LocalDate.now();
        this.periodStart = null;
        this.periodEnd = null;
        this.amount = 0.0;
        this.due = null;
        this.serviceID = 0;
    }

    // primary constructor
    public _Bill(int billID, LocalDate date, LocalDate periodStart, LocalDate periodEnd, double amount, LocalDate due, int serviceID) {
        this.billID = billID;
        this.date = date;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.amount = amount;
        this.due = due;
        this.serviceID = serviceID;
    }

    // copy constructor
    public _Bill(_Bill fee) {
        this.billID = fee.billID;
        this.date = fee.date;
        this.periodStart = fee.periodStart;
        this.periodEnd = fee.periodEnd;
        this.amount = fee.amount;
        this.due = fee.due;
        this.serviceID = fee.serviceID;
    }    

    public int getBillID() {
        return this.billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        return this.due;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
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
        return billID == _Bill.billID && Objects.equals(date, _Bill.date) && Objects.equals(periodStart, _Bill.periodStart) && Objects.equals(periodEnd, _Bill.periodEnd) && amount == _Bill.amount && Objects.equals(due, _Bill.due) && serviceID == _Bill.serviceID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billID, date, periodStart, periodEnd, amount, due, serviceID);
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
