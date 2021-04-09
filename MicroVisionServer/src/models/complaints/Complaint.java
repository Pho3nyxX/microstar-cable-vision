package models.complaints;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "complaint")
public class Complaint extends _Complaint{

    public Complaint(int complaintId, String status, String details, String typeOfIssue, LocalDateTime dateRaised,
            int accountId) {
        super(complaintId, status, details, typeOfIssue, dateRaised, accountId);
    }
    
}
