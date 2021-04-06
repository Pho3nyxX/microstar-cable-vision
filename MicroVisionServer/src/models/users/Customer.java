package models.users;

import javax.persistence.*;

import models.users._Customer;
import models.users._User;

@Entity
@Table(name = "customer")
public class Customer extends _Customer{
    private static final long serialVersionUID = -7122240510909524901L;

    @Override
    public void LodgeComplaint() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean save() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }

    public Customer(){

    }
    public Customer(int userID, String firstName, String lastName, String middleName, String password, int age,
    String gender, String email, _Address address){
        super(userID, firstName, lastName, middleName, password, age, gender, email, address);
    }
}
