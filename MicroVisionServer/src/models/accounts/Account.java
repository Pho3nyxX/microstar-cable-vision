package models.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import models.users.Customer;

@Entity
@Table(name = "account")
public class Account extends _Account{
    @ManyToOne
    @JoinColumn(name="customer_id")
    Customer customer;
    
    @OneToMany
    @JoinColumn(name = "account_id", referencedColumnName="account_id")
    protected List<Service> services;

    @OneToMany
    @JoinColumn(name = "account_id", referencedColumnName="account_id")
    protected List<Payment> payments;

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Account(Customer customer, List<Service> services, List<Payment> payments) {
        this.customer = customer;
        this.services = services;
        this.payments = payments;
    }
    public Account(_Account ac, Customer customer, List<Service> services, List<Payment> payments) {
        super(ac);
        this.customer = customer;
        this.services = services;
        this.payments = payments;
    }
    public Account(int accountID, String accountStatus, double amountDue, int customerID, Customer customer,
            List<Service> services, List<Payment> payment) {
        super(accountID, accountStatus, amountDue);
        this.customer = customer;
        this.services = services;
        this.payments = payments;
    }

    public Account(String accountStatus, double amountDue, Customer customer) {
        super();
        this.setAccountStatus(accountStatus);
        this.setAmountDue(amountDue);
        this.customer = customer;
        this.services = new ArrayList<>();
        this.payments = new ArrayList<>();
    }
}
