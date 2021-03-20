package models.users;

import java.io.Serializable;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "user")
public abstract  class _Address implements Serializable {
    @Column(name="parish")
    String parish;
    @Column(name="town")
    String town;
    @Column(name="street")
    String street;

    public _Address(String parish, String town, String street) {
        this.parish = parish;
        this.town = town;
        this.street = street;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "_Address [parish=" + parish + ", street=" + street + ", town=" + town + "]";
    }

    
}
