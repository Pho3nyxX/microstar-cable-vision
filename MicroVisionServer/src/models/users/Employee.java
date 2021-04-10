package models.users;


import models.chat.Message;
import models.users._Employee;
import models.users._User;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "emp_id")
@NamedQueries({
    @NamedQuery(name = "Employee.findByUsername",
                query = "SELECT u FROM Employee u WHERE u.username = :username")
    })
public class Employee extends _Employee{
    /**
     *
     */
    private static final long serialVersionUID = -7407503122655621232L;

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
