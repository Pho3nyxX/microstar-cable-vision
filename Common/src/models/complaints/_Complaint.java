package models.complaints;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

// Annotations
@MappedSuperclass
public abstract class _Complaint implements Serializable {

    @Id
    @Column(name = "complaint_id")
    int complaintId;

    @Column(name = "status")
    String status;

    @Column(name = "details")
    String details;

    @Column(name = "type_of_issue")
    String typeOfIssue;

    @Column(name = "date_raised")
    LocalDateTime dateRaised;

    @Column(name = "account_id")
    int accountId;

    public _Complaint() {
    }

    public _Complaint(int complaintId, String status, String details, String typeOfIssue, LocalDateTime dateRaised, int accountId) {
        this.complaintId = complaintId;
        this.status = status;
        this.details = details;
        this.typeOfIssue = typeOfIssue;
        this.dateRaised = dateRaised;
        this.accountId = accountId;
    }

    public int getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTypeOfIssue() {
        return this.typeOfIssue;
    }

    public void setTypeOfIssue(String typeOfIssue) {
        this.typeOfIssue = typeOfIssue;
    }

    public LocalDateTime getDateRaised() {
        return this.dateRaised;
    }

    public void setDateRaised(LocalDateTime dateRaised) {
        this.dateRaised = dateRaised;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public _Complaint complaintId(int complaintId) {
        setComplaintId(complaintId);
        return this;
    }

    public _Complaint status(String status) {
        setStatus(status);
        return this;
    }

    public _Complaint details(String details) {
        setDetails(details);
        return this;
    }

    public _Complaint typeOfIssue(String typeOfIssue) {
        setTypeOfIssue(typeOfIssue);
        return this;
    }

    public _Complaint dateRaised(LocalDateTime dateRaised) {
        setDateRaised(dateRaised);
        return this;
    }

    public _Complaint accountId(int accountId) {
        setAccountId(accountId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Complaint)) {
            return false;
        }
        _Complaint _Complaint = (_Complaint) o;
        return complaintId == _Complaint.complaintId && Objects.equals(status, _Complaint.status) && Objects.equals(details,
                _Complaint.details) && Objects.equals(typeOfIssue, _Complaint.typeOfIssue) && Objects.equals(dateRaised,
                _Complaint.dateRaised) && accountId == _Complaint.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(complaintId, status, details, typeOfIssue, dateRaised, accountId);
    }

    @Override
    public String toString() {
        return "{" +
                " complaintId='" + getComplaintId() + "'" +
                ", status='" + getStatus() + "'" +
                ", details='" + getDetails() + "'" +
                ", typeOfIssue='" + getTypeOfIssue() + "'" +
                ", dateRaised='" + getDateRaised() + "'" +
                ", accountId='" + getAccountId() + "'" +
                "}";
    }
}
