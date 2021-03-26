package models.complaints;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// Annotations
@Entity
@Table(name = "visit")
public class _Visit implements Serializable{

    @Column(name="visit_id")
    int visitID;

    @Column(name="date_of_visit")
    LocalDate dateOfVisit;

    @Column(name="schedule_date")
    LocalDate scheduleDate;

    @Column(name="complete")
    boolean complete;

    // default constructor
    public _Visit() {
        this.visitID = 0;
        this.dateOfVisit = null;
        this.scheduleDate = null;
        this.complete = false;
    }

    // primary constructor
    public _Visit(int visitId, LocalDate dateOfVisit, LocalDate scheduleDate, boolean complete) {
        this.visitID = visitId;
        this.dateOfVisit = dateOfVisit;
        this.scheduleDate = scheduleDate;
        this.complete = complete;
    }

    // copy constructor
    public _Visit(_Visit travel) {
        this.visitID = travel.visitID;
        this.dateOfVisit = travel.dateOfVisit;
        this.scheduleDate = travel.scheduleDate;
        this.complete = travel.complete;
    }

    public int getVisitId() {
        return this.visitID;
    }

    public void setVisitId(int visitId) {
        this.visitID = visitId;
    }

    public LocalDate getDateOfVisit() {
        return this.dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public LocalDate getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public _Visit visitId(int visitId) {
        setVisitId(visitId);
        return this;
    }

    public _Visit dateOfVisit(LocalDate dateOfVisit) {
        setDateOfVisit(dateOfVisit);
        return this;
    }

    public _Visit scheduleDate(LocalDate scheduleDate) {
        setScheduleDate(scheduleDate);
        return this;
    }

    public _Visit complete(boolean complete) {
        setComplete(complete);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Visit)) {
            return false;
        }
        _Visit _Visit = (_Visit) o;
        return visitID == _Visit.visitID && Objects.equals(dateOfVisit, _Visit.dateOfVisit) && Objects.equals(scheduleDate, _Visit.scheduleDate) && complete == _Visit.complete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitID, dateOfVisit, scheduleDate, complete);
    }

    @Override
    public String toString() {
        return "{" +
            " visitId='" + getVisitId() + "'" +
            ", dateOfVisit='" + getDateOfVisit() + "'" +
            ", scheduleDate='" + getScheduleDate() + "'" +
            ", complete='" + isComplete() + "'" +
            "}";
    }

    
}
