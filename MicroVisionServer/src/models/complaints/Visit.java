package models.complaints;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class Visit extends _Visit{

    // @ManyToOne
    // @JoinColumn
    // Complaint complaint;

    public Visit(int visitId, LocalDate dateOfVisit, LocalDate scheduleDate, boolean complete) {
        
        super(visitId, dateOfVisit, scheduleDate, complete);
    }
    
}
