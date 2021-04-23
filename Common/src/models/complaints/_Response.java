package models.complaints;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;


// Annotations
@MappedSuperclass
public class _Response implements Serializable {

    @Id
    @Column(name="response_id")
    protected int responseID;

    @Column(name="response_detail")
    protected String details;

    @Column(name="response_date")
    protected LocalDate responseDate;

    @Column(name="complaint_id" )
    int complaintID;

    @Transient
    protected ArrayList<String> validation_errors;

        /**
     * validate members to ensure all dat falls within acceptable ranges
     * @return
     */
    public boolean validate(){
        boolean valid = true;

        // check if each fields data is valid        
        if(this.details.isBlank()){
            
            this.validation_errors.add("Detaiks cannot be blank.");
            
            valid = false;
        }
        return valid;

    }


    // default constructor
    public _Response() {
        this.responseID = 0;
        this.details = "";
        this.responseDate = null;
        this.complaintID = 0;
    }

    // primary constructor
    public _Response(int responseID, String detail, LocalDate responseDate, int complaintID) {
        this.responseID = responseID;
        this.details = detail;
        this.responseDate = responseDate;
        this.complaintID = complaintID;
    }

    // copy constructor
    public _Response(_Response call) {
        this.responseID = call.responseID;
        this.details = call.details;
        this.responseDate = call.responseDate;
        this.complaintID = call.complaintID;
    }

    public int getResponseID() {
        return this.responseID;
    }

    public void setResponseID(int responseID) {
        this.responseID = responseID;
    }

    public String getDetail() {
        return this.details;
    }

    public void setDetail(String detail) {
        this.details = detail;
    }

    public LocalDate getResponseDate() {
        return this.responseDate;
    }

    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }


    public int getComplaintID() {
        return this.complaintID;
    }
    
    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }
    

    public _Response responseID(int responseID) {
        setResponseID(responseID);
        return this;
    }

    public _Response detail(String detail) {
        setDetail(detail);
        return this;
    }

    public _Response responseDate(LocalDate responseDate) {
        setResponseDate(responseDate);
        return this;
    }

    // public _Response complaintID(int complaintID) {
    //     setComplaintID(complaintID);
    //     return this;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Response)) {
            return false;
        }
        _Response _Response = (_Response) o;
        return responseID == _Response.responseID && Objects.equals(details, _Response.details) && Objects.equals(responseDate, _Response.responseDate) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseID, details, responseDate);
    }

    @Override
    public String toString() {
        return "{" +
            " responseID='" + getResponseID() + "'" +
            ", detail='" + getDetail() + "'" +
            ", responseDate='" + getResponseDate() + "'" +
            // ", complaintID='" + getComplaintID() + "'" +
            "}";
    }

    
}
