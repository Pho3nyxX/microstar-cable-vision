package users;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "user")
public abstract class _User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    int userID;

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

    //default constructor
    public _User() {
        this.userID = 0;
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.password = "";
        this.age = 0;
        this.gender = "";
    }

    //abstract methods
    public abstract boolean login(String username, String password);
    
    public abstract boolean logout(String userid);

    public abstract boolean register();

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

    //copy constructor
    public _User(_User client) {
        this.userID = client.userID;
        this.firstName = client.firstName;
        this.lastName = client.lastName;
        this.middleName = client.middleName;
        this.password = client.password;
        this.age = client.age;
        this.gender = client.gender;
    }

    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "User [age=" + age + ", firstName=" + firstName + ", gender=" + gender + ", lastName=" + lastName
                + ", middleName=" + middleName + ", password=" + password + ", userID=" + userID + "]";
    }
    
}
