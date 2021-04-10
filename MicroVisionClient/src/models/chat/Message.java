package models.chat;

import java.time.LocalDateTime;

public class Message extends _Message{

    public Message(int messageId, String text, boolean read, LocalDateTime date, int recipientId, int senderId,
            int complaintId) {
        super(messageId, text, read, date, recipientId, senderId, complaintId);
    }
    
}
