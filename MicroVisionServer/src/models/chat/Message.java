package models.chat;

import java.time.LocalDateTime;

import javax.persistence.*;

import models.complaints.Complaint;

@Entity
@Table(name = "message")
public class Message extends _Message{


    // @ManyToOne
    // @JoinColumn(name="complaint_id")
    // protected Complaint complaint;

    
    /**
     *
     */
    private static final long serialVersionUID = 5793953649770283394L;

    public Message(int messageId, String text, boolean read, LocalDateTime date, int recipientId, int senderId, int complaintId) {
        super(messageId, text, read, date, recipientId, senderId, complaintId);
    }

/*    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
*/
    

    
}
