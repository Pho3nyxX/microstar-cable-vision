package models.complaints;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import models.chat.Message;

@Entity
@Table(name = "complaint")
public class Complaint extends _Complaint{

    @OneToMany
    @JoinColumn(name = "complaint_id", referencedColumnName="complaint_id")
    protected List<Response> responses;


    // @OneToMany
    // @JoinColumn(name = "complaint_id", referencedColumnName="complaint_id")
    // protected List<Visit> visits;

    // @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL)
    // // @JoinColumn(name = "complaint_id", referencedColumnName="complaint_id")
    // protected List<Message> messages;

    public Complaint(int complaintId, String status, String details, String typeOfIssue, LocalDateTime dateRaised, int accountId) {
        
        super(complaintId, status, details, typeOfIssue, dateRaised, accountId);
        
        this.responses = new ArrayList<>();
    }

    public Complaint(){
        super();
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public void addResponse(Response response){
        this.responses.add(response);
        response.setComplaint(this);
    }
/*
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    } 

    public void addMessages(Message messages){
        this.messages.add(messages);
        // messages.setComplaint(this);
    }

    
    */
}
