package models.users;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends _Address{

    public Address(int address_id, String parish, String town, String street, int customer_id) {
        super(address_id, parish, town, street, customer_id);
    }
}
