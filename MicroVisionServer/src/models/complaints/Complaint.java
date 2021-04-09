package models.complaints;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import models.chat.Message;

@Entity
@Table(name = "complaint")
public class Complaint extends _Complaint{

    @OneToMany
    @JoinColumn(name = "complaint_id", referencedColumnName="complaint_id")
    protected List<Response> responses;


    @OneToMany
    @JoinColumn(name = "complaint_id", referencedColumnName="complaint_id")
    protected List<Visit> visits;

    @OneToMany
    @JoinColumn(name = "complaint_id", referencedColumnName="complaint_id")
    protected List<Message> messages;

    public Complaint(int complaintId, String status, String details, String typeOfIssue, LocalDateTime dateRaised,
            int accountId) {
        super(complaintId, status, details, typeOfIssue, dateRaised, accountId);
    }
    
}
