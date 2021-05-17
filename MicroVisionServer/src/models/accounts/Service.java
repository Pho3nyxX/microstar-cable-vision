package models.accounts;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "service")

public class Service extends _Service{
    /**
     *
     */
    private static final long serialVersionUID = -5707531268648422965L;

    @OneToMany
    @JoinColumn(name = "service_id", referencedColumnName="service_id")
    protected List<Bill> bills;

    public Service(int serviceID, String typeOfService, LocalDate dateInitiated, String status, int accountID,
            List<Bill> service) {
        super(serviceID, typeOfService, dateInitiated, status, accountID);
        this.bills = service;
    }

    public Service(List<Bill> service) {
        super();
        this.bills = service;
    }

    public Service() {
        super();
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
