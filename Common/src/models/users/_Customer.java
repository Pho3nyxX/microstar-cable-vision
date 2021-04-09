package models.users;

import java.util.Objects;

import javax.persistence.*;

import utilities.Validator;

// Annotations
@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "customer_id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class _Customer extends _User {

    /**
     *
     */
    private static final long serialVersionUID = -7122240510909524901L;

    // @Id
    // @Column(name = "customer_id")
    // protected int customer_id;
    
    @Column(name = "email")
    protected String email;
    
    @Transient
    protected _Address address;

    // public abstract void LodgeComplaint();


    @Override
    public boolean validate() {
        //TODO implement individual validators
        boolean valid = super.validate();

        // check if each fields data is valid
        if( !( Validator.validate(this.email, Validator.EMAIL) ) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }
        return valid;
    }
    

    // default constructor
    public _Customer() {
        super();
        this.email = "";
        this.address = null;
    }

    // primary constructor
    public _Customer(int userID, String firstName, String lastName, String middleName, String password, int age,
            String gender, String email, _Address address) {
        super(userID, firstName, lastName, middleName, password, age, gender);
        this.email = email;
        this.address = address;
    }

    // copy constructor
    public _Customer(_Customer client) {
        super(
            client.getUserID(),
            client.getfirstName(),
            client.getlastName(),
            client.getmiddleName(),
            client.getPassword(),
            client.getAge(),
            client.getGender()
        );
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
