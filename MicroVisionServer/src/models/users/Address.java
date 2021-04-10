package models.users;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends _Address{

    @ManyToOne
    @JoinColumn(name="customer_id")
    Customer customer;

    public Address(int address_id, String parish, String town, String street, int customer_id) {
        super(address_id, parish, town, street, customer_id);
    }
    public Address(String parish, String town, String street) {
        super();
        this.setParish(parish);
        this.setTown(town);
        this.setStreet(street);
    }

    public Address() {
        super();
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
