package models.users;


import models.users._Employee;
import models.users._User;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "emp_id")
public class Employee extends _Employee{

    @OneToOne(mappedBy="customer")
    protected ContactNumber phone;


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
}
