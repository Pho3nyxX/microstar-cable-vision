package models.users;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "address")
public abstract  class _Address implements Serializable {

    @Column(name="parish")
    String parish;

    @Column(name="town")
    String town;

    @Column(name="street")
    String street;

    // default constructor
    public _Address() {
        this.parish = "";
        this.town = "";
        this.street = "";
    }

    // primary constructor
    public _Address(String parish, String town, String street) {
        this.parish = parish;
        this.town = town;
        this.street = street;
    }

    // copy constructor
    public _Address(_Address location) {
        this.parish = location.parish;
        this.town = location.town;
        this.street = location.street;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Address)) {
            return false;
        }
        _Address _Address = (_Address) o;
        return Objects.equals(parish, _Address.parish) && Objects.equals(town, _Address.town) && Objects.equals(street, _Address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parish, town, street);
    }

    @Override
    public String toString() {
        return "{" +
            " parish='" + getParish() + "'" +
            ", town='" + getTown() + "'" +
            ", street='" + getStreet() + "'" +
            "}";
    }
}
