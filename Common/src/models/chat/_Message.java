package models.chat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@Entity
@Table(name = "message")
public abstract class _Message implements Serializable {

    @Column(name = "text")
    String text;

    @Column(name = "read")
    boolean read;

    @Column(name = "date")
    LocalDateTime date;

    @Column(name = "recipient_id")
    int recipientId;

    @Column(name = "sender_id")
    int senderId;

    @Column(name = "complaint_id")
    int complaintId;

    // default constructor
    public _Message() {
        this.text = "";
        this.read = false;
        this.date = LocalDateTime.now();
        this.recipientId = 0;
        this.senderId = 0;
        this.complaintId = 0;
    }

    // primary constructor
    public _Message(String text, boolean read, LocalDateTime date, int recipientId, int senderId, int complaintId) {
        this.text = text;
        this.read = read;
        this.date = date;
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.complaintId = complaintId;
    }

    // copy constructor
    public _Message(_Message word) {
        this.text = word.text;
        this.read = word.read;
        this.date = word.date;
        this.recipientId = word.recipientId;
        this.senderId = word.senderId;
        this.complaintId = word.complaintId;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRead() {
        return this.read;
    }

    public boolean getRead() {
        return this.read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getRecipientId() {
        return this.recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getSenderId() {
        return this.senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public _Message text(String text) {
        setText(text);
        return this;
    }

    public _Message read(boolean read) {
        setRead(read);
        return this;
    }

    public _Message date(LocalDateTime date) {
        setDate(date);
        return this;
    }

    public _Message recipientId(int recipientId) {
        setRecipientId(recipientId);
        return this;
    }

    public _Message senderId(int senderId) {
        setSenderId(senderId);
        return this;
    }

    public _Message complaintId(int complaintId) {
        setComplaintId(complaintId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Message)) {
            return false;
        }
        _Message _Message = (_Message) o;
        return Objects.equals(text, _Message.text) && read == _Message.read && Objects.equals(date, _Message.date) && recipientId == _Message.recipientId && senderId == _Message.senderId && complaintId == _Message.complaintId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, read, date, recipientId, senderId, complaintId);
    }

    @Override
    public String toString() {
        return "{" +
            " text='" + getText() + "'" +
            ", read='" + isRead() + "'" +
            ", date='" + getDate() + "'" +
            ", recipientId='" + getRecipientId() + "'" +
            ", senderId='" + getSenderId() + "'" +
            ", complaintId='" + getComplaintId() + "'" +
            "}";
    }

}
