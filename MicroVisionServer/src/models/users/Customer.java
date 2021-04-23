package models.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import models.accounts.Account;
import models.chat.Message;
import models.users._Customer;
import models.users._User;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "customer_id")
@NamedQueries({
@NamedQuery(name = "Customer.findByUsername",
            query = "SELECT u FROM Customer u WHERE u.username = :username")
})

public class Customer extends _Customer{
    
    private static final long serialVersionUID = -7122240510909524901L;

    @OneToOne(mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected ContactNumber phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    // @JoinColumn(name = "customer_id", referencedColumnName="customer_id")
    protected List<Address> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "customer_id", referencedColumnName="customer_id")
    protected List<Account> accounts;

    
    @OneToMany
    @JoinColumn(name="sender_id", referencedColumnName="customer_id")
    protected List<Message> messages_sent;

    @OneToMany
    @JoinColumn(name = "recipient_id", referencedColumnName="customer_id")
    protected List<Message> messages_recieved;

    //@Override
    public void LodgeComplaint() {
        // TODO Auto-generated method stub
        
    }

   // @Override
    public boolean save() {
        // TODO Auto-generated method stub
        return false;
    }

   // @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }

    public Customer(){
        super();
        this.addresses = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }
    public Customer(int userID, String username, String firstName, String lastName, String middleName, String password, int age,
    String gender, String email, Address address){
        super(userID, username, firstName, lastName, middleName, password, age, gender, email, address);
        this.accounts = new ArrayList<>();
        this.addresses = new ArrayList<>();
        this.addAddress(address);
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> address) {
        this.addresses = address;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
        account.setCustomer(this);
    }

    public List<Account> getAccounts(){
        return this.accounts;
    }
    public ContactNumber getPhone() {
        return phone;
    }

    public void setPhone(ContactNumber phone) {
        this.phone = phone;
        phone.setCustomer(this);
    }
}
