package models.users;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "user")
public class _ContactNumber {
    @Column(name="contact_num")
    String contactNum;
    @Column(name="user_id")
    int userId;
    
}
