package models.complaints;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Response extends _Response{

    @ManyToOne
    @JoinColumn(name="complaint_id", nullable=false)
    Complaint complaint;

    public Response(int responseID, String detail, LocalDate responseDate, int complaintID) {
        
        super(responseID, detail, responseDate, complaintID);
    }

    public Response(int responseID, String detail, LocalDate responseDate) {

        super(responseID, detail, responseDate, 0);
    
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
