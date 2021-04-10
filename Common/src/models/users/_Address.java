package models.users;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@MappedSuperclass
public class _Address implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = -5866191259253248590L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int address_id;

    @Column(name="parish")
    String parish;

    @Column(name="town")
    String town;

    @Column(name="street")
    String street;

    // @Column(name="customer_id")
    // int customer_id;

    // default constructor
    public _Address() {
        this.address_id = 0;
        this.parish = "";
        this.town = "";
        this.street = "";
        // this.customer_id = 0;
    }

    // primary constructor
    public _Address(int address_id, String parish, String town, String street, int customer_id) {
        this.address_id = address_id;
        this.parish = parish;
        this.town = town;
        this.street = street;
        // this.customer_id = customer_id;
    }
    
    // copy constructor
    public _Address(_Address location) {
        this.address_id = location.address_id;
        this.parish = location.parish;
        this.town = location.town;
        this.street = location.street;
        // this.customer_id = location.customer_id;
    }

    /**--------------------------------------------------------------------------------- */


    public int getAddress_id() {
        return this.address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getParish() {
        return this.parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // public int getCustomer_id() {
    //     return this.customer_id;
    // }

    // public void setCustomer_id(int customer_id) {
    //     this.customer_id = customer_id;
    // }

    public _Address address_id(int address_id) {
        setAddress_id(address_id);
        return this;
    }

    public _Address parish(String parish) {
        setParish(parish);
        return this;
    }

    public _Address town(String town) {
        setTown(town);
        return this;
    }

    public _Address street(String street) {
        setStreet(street);
        return this;
    }

    // public _Address customer_id(int customer_id) {
    //     setCustomer_id(customer_id);
    //     return this;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Address)) {
            return false;
        }
        _Address _Address = (_Address) o;
        return address_id == _Address.address_id && Objects.equals(parish, _Address.parish) && Objects.equals(town, _Address.town) && Objects.equals(street, _Address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address_id, parish, town, street);
    }

    @Override
    public String toString() {
        return "{" +
            " address_id='" + getAddress_id() + "'" +
            ", parish='" + getParish() + "'" +
            ", town='" + getTown() + "'" +
            ", street='" + getStreet() + "'" +
            // ", customer_id='" + getCustomer_id() + "'" +
            "}";
    }

}
