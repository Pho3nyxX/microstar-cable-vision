package users;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "customer")
public abstract class _Customer extends _User{

    // @id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="customer_id")

    @Column(name="email")
    String email;

    @Column(name="address")
    String address;

    // default constructor
    public _Customer() {
        super();
        this.email = "";
        this.address = "";
    }

    // primary constructor
    public _Customer(int userID, String firstName, String lastName, String middleName, String password, int age,
            String gender, String email, String address) {
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

    // getters & setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", email=" + email + "]";
    }

    
}
