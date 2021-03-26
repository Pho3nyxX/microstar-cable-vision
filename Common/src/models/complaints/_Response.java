package models.complaints;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// Annotations
@Entity
@Table(name = "response")
public class _Response implements Serializable {

    @Column(name="response_id")
    int responseID;

    @Column(name="detail")
    String detail;

    @Column(name="response_date")
    LocalDate responseDate;

    @Column(name="complaint_id")
    int complaintID;

    // default constructor
    public _Response() {
        this.responseID = 0;
        this.detail = "";
        this.responseDate = null;
        this.complaintID = 0;
    }

    // primary constructor
    public _Response(int responseID, String detail, LocalDate responseDate, int complaintID) {
        this.responseID = responseID;
        this.detail = detail;
        this.responseDate = responseDate;
        this.complaintID = complaintID;
    }

    // copy constructor
    public _Response(_Response call) {
        this.responseID = call.responseID;
        this.detail = call.detail;
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
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public _Response complaintID(int complaintID) {
        setComplaintID(complaintID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Response)) {
            return false;
        }
        _Response _Response = (_Response) o;
        return responseID == _Response.responseID && Objects.equals(detail, _Response.detail) && Objects.equals(responseDate, _Response.responseDate) && complaintID == _Response.complaintID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseID, detail, responseDate, complaintID);
    }

    @Override
    public String toString() {
        return "{" +
            " responseID='" + getResponseID() + "'" +
            ", detail='" + getDetail() + "'" +
            ", responseDate='" + getResponseDate() + "'" +
            ", complaintID='" + getComplaintID() + "'" +
            "}";
    }

    
}
