package models.users;

import javax.persistence.*;

@Entity
@Table(name = "contactnum")
public class ContactNumber extends _ContactNumber{
    /**
     *
     */
    
    public ContactNumber(String contactNum, int userId) {
        super(contactNum, userId);
    }
}
