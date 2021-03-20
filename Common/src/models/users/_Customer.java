package models.users;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "customer")
public abstract class _Customer extends _User implements Serializable {
    // @id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="customer_id")

    @Column(name = "email")
    String email;

    _Address address;

    public abstract void LodgeComplaint();

    public _Customer() {
        super();
        this.email = "";
        this.address = null;
    }

    public _Customer(int userID, String firstName, String lastName, String middleName, String password, int age,
            String gender, String email, _Address address) {
        super(userID, firstName, lastName, middleName, password, age, gender);
        this.email = email;
        this.address = address;
    }

    // copy constructor
    public _Customer(_Customer client) {
        super(client);
        this.email = client.email;
        this.address = client.address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public _Address getAddress() {
        return this.address;
    }

    public void setAddress(_Address address) {
        this.address = address;
    }

    public _Customer email(String email) {
        setEmail(email);
        return this;
    }

    public _Customer address(_Address address) {
        setAddress(address);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Customer)) {
            return false;
        }
        _Customer _Customer = (_Customer) o;
        return Objects.equals(email, _Customer.email) && Objects.equals(address, _Customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, address);
    }

    @Override
    public String toString() {
        return "{" + " email='" + getEmail() + "'" + ", address='" + getAddress() + "'" + "}";
    }

}
