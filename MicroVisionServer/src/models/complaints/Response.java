package models.complaints;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Response extends _Response{

    public Response(int responseID, String detail, LocalDate responseDate, int complaintID) {
        super(responseID, detail, responseDate, complaintID);
    }
    
}
