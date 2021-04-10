package models.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;
import utilities.Validator;

// Annotations
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class _User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    protected int userID;

    @Column(name="username")
    protected String username;

    @Column(name="first_Name")
    protected String firstName;
    
    @Column(name="last_Name")
    protected String lastName;

    @Column(name="middle_Name")
    protected String middleName;

    @Column(name="password")
    protected String password;

    @Column(name="age")
    protected int age;

    @Column(name="gender")
    protected String gender;

    @Column(name="online_status")
    protected boolean isOnline;

    @Transient
    protected ArrayList<String> validation_errors;

    //abstract methods
    // public abstract boolean save();
    // public abstract boolean delete();


    public boolean validate() {
        //TODO implement individual validators and remove email
        boolean valid = true;

        // check if each fields data is valid
        // validate username
        if( !( Validator.validate(this.username, Validator.USERNAME) ) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }
        // validate password
        if( !( Validator.validate(this.password, Validator.PASSWORD) ) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }
        // validate gender
        if( !(this.gender.equals("M")) && !(this.gender.equals("F")) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }

        /*// validate firstName
        if( !( Validator.validate(this.firstName, Validator.EMAIL) ) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }
        // validate middleName
        if( !( Validator.validate(this.middleName, Validator.EMAIL) ) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }
        // validate lastName
        if( !( Validator.validate(this.lastName, Validator.EMAIL) ) ){
            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }*/


        return valid;
    }

    // default constructor
    public _User() {
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        // this.phone = [""];
        this.age = 0;
        this.gender = "";
        this.isOnline = false;
        this.validation_errors = new ArrayList();
    }

    //primary constructor 1
    public _User(int userID, String username, String firstName, String lastName, String middleName, String password, int age,
    String gender) {
        this.username = username;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.isOnline = false;
        this.validation_errors = new ArrayList();
        
    }
    
    // primary constructor 2
    public _User(String username, String firstName, String lastName, String middleName, String password, int age, String gender) {
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        // this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.isOnline = false;
        this.validation_errors = new ArrayList();
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userid) {
        this.userID = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfirstName() {
        return this.firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return this.lastName;
    }

    public void setmiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getmiddleName() {
        return this.middleName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public _ContactNumber getPhone() {
    //     return this.phone;
    // }

    // public void setPhone(_ContactNumber phone) {
    //     this.phone = phone;
    // }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getisOnline() { return this.isOnline; }

    public void setisOnline(boolean online) { this.isOnline = online; }

    public ArrayList<String> getValidation_errors() {
        return this.validation_errors;
    }

    public void setValidation_errors(ArrayList<String> validation_errors) {
        this.validation_errors = validation_errors;
    }

    public _User username(String username) {
        setUsername(username);
        return this;
    }

    public _User firstName(String firstName) {
        setfirstName(firstName);
        return this;
    }

    public _User lastName(String lastName) {
        setlastName(lastName);
        return this;
    }

    public _User password(String password) {
        setPassword(password);
        return this;
    }

    // public _User phone(_ContactNumber phone) {
    //     setPhone(phone);
    //     return this;
    // }

    public _User age(int age) {
        setAge(age);
        return this;
    }

    public _User gender(String gender) {
        setGender(gender);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _User)) {
            return false;
        }
        _User _User = (_User) o;
        return Objects.equals(username, _User.username) && Objects.equals(firstName, _User.firstName) && Objects.equals(lastName, _User.lastName) && Objects.equals(password, _User.password) && age == _User.age && Objects.equals(gender, _User.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, password, age, gender);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", firstName='" + getfirstName() + "'" +
            ", lastName='" + getlastName() + "'" +
            ", password='" + getPassword() + "'" +
            // ", phone='" + getPhone() + "'" +
            ", age='" + getAge() + "'" +
            ", gender='" + getGender() + "'" +
            "}";
    }
    
}
