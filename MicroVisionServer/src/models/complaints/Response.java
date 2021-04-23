package models.complaints;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Response extends _Response{

    // @ManyToOne
    // @JoinColumn(name="complaint_id")
    // Complaint complaint;

    // @Column(name = "complaint_id", insertable = false, updatable = false)
    // int complaintId;

    public Response(int responseID, String detail, LocalDate responseDate, int complaintID) {
        
        super(responseID, detail, responseDate, complaintID);
    }

    public Response(int responseID, String detail, LocalDate responseDate) {

        super(responseID, detail, responseDate, 0);
    
    }

    public Response(String detail, LocalDate responseDate, Complaint complaint)  {
        super();
        this.details = detail;
        this.responseDate = responseDate;
        // this.complaint = complaint;
    }

    // public Complaint getComplaint() {
    //     return complaint;
    // }

    // public void setComplaint(Complaint complaint) {
    //     this.complaint = complaint;
    // }
}
