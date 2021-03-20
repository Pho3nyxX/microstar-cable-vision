package models.users;

import java.util.Objects;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "user")

public abstract class _User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    int userID;

    @Column(name="username")
    String username;

    @Column(name="first_Name")
    String firstName;
    
    @Column(name="last_Name")
    String lastName;

    @Column(name="middle_Name")
    String middleName;

    @Column(name="password")
    String password;

    @Column(name="age")
    int age;

    @Column(name="gender")
    String gender;

    _ContactNumber[] phone;

    //abstract methods
    public abstract boolean login(String username, String password);
    
    public abstract boolean logout(String userid);

    public abstract boolean register();


    public _User() {
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        // this.phone = [""];
        this.age = 0;
        this.gender = "";
    }

    //primary constructor
    public _User(int userID, String firstName, String lastName, String middleName, String password, int age,
            String gender) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }


    public _User(String username, String firstName, String lastName, String password, _ContactNumber[] phone, int age, String gender) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
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

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public _ContactNumber[] getPhone() {
        return this.phone;
    }

    public void setPhone(_ContactNumber[] phone) {
        this.phone = phone;
    }

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

    public _User phone(_ContactNumber[] phone) {
        setPhone(phone);
        return this;
    }

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
        return Objects.equals(username, _User.username) && Objects.equals(firstName, _User.firstName) && Objects.equals(lastName, _User.lastName) && Objects.equals(password, _User.password) && Objects.equals(phone, _User.phone) && age == _User.age && Objects.equals(gender, _User.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, password, phone, age, gender);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", firstName='" + getfirstName() + "'" +
            ", lastName='" + getlastName() + "'" +
            ", password='" + getPassword() + "'" +
            ", phone='" + getPhone() + "'" +
            ", age='" + getAge() + "'" +
            ", gender='" + getGender() + "'" +
            "}";
    }
    
}
