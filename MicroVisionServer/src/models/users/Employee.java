package models.users;


import models.chat.Message;
import models.users._Employee;
import models.users._User;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "emp_id")
public class Employee extends _Employee{


        
    @OneToMany
    @JoinColumn(name="sender_id", referencedColumnName="emp_id")
    protected List<Message> messages_sent;

    @OneToMany
    @JoinColumn(name = "recipient_id", referencedColumnName="emp_id")
    protected List<Message> messages_recieved;

    //@Override
    public boolean save() {
        // TODO Auto-generated method stub
        return false;
    }

    
    //@Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }


    public Employee() {
        // this.phone = phone;
    }


    public Employee(int userID, String username, String firstName, String lastName, String middleName, String password,
            int age, String gender, String role, String status) {
        super(userID, username, firstName, lastName, middleName, password, age, gender, role, status);
    }
    
}
