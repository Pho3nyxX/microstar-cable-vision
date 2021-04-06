package models.chat;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message extends _Message{
    /**
     *
     */
    private static final long serialVersionUID = 5793953649770283394L;

    public Message(int messageId, String text, boolean read, LocalDateTime date, int recipientId, int senderId, int complaintId) {
        super(messageId, text, read, date, recipientId, senderId, complaintId);
    }

    
}
