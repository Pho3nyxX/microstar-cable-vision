package models.users;

import java.io.Serializable;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "user")
public class _ContactNumber implements Serializable{
    @Column(name="contact_num")
    String contactNum;
    @Column(name="user_id")
    int userId;
    
}
