package models.users;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "contactnumber")
public class _ContactNumber implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -6003754842868135320L;

    @Column(name="contact_num")
    String contactNum;

    @Column(name="user_id")
    int userId;

    public boolean validate(){
        boolean valid = false;
        
        return valid;
    }
    /**------------------------------------------------------------- */
    // default constructor
    public _ContactNumber() {
        this.contactNum = "";
        this.userId = 0;
    }

    // primary constructor
    public _ContactNumber(String contactNum, int userId) {
        this.contactNum = contactNum;
        this.userId = userId;
    }

    // copy constructor
    public _ContactNumber(_ContactNumber num) {
        this.contactNum = num.contactNum;
        this.userId = num.userId;
    }    

    public String getContactNum() {
        return this.contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public _ContactNumber contactNum(String contactNum) {
        setContactNum(contactNum);
        return this;
    }

    public _ContactNumber userId(int userId) {
        setUserId(userId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _ContactNumber)) {
            return false;
        }
        _ContactNumber _ContactNumber = (_ContactNumber) o;
        return Objects.equals(contactNum, _ContactNumber.contactNum) && userId == _ContactNumber.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactNum, userId);
    }

    @Override
    public String toString() {
        return "{" +
            " contactNum='" + getContactNum() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }


    
}
