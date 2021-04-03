package models.accounts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// Annotations
@Entity
@Table(name = "service")
public class _Service implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6525110385549761655L;

    @Column(name="service_id")
    int serviceID;

    @Column(name="type_of_service")
    String typeOfService;

    @Column(name="date_initiated")
    LocalDate dateInitiated;

    @Column(name="status")
    String status;

    @Column(name="account_id")
    int accountID;

    // default constructor
    public _Service() {
        this.serviceID = 0;
        this.typeOfService = "";
        this.dateInitiated = LocalDate.now();
        this.status = "";
        this.accountID = 0;
    }

    // primary constructor
    public _Service(int serviceID, String typeOfService, LocalDate dateInitiated, String status, int accountID) {
        this.serviceID = serviceID;
        this.typeOfService = typeOfService;
        this.dateInitiated = dateInitiated;
        this.status = status;
        this.accountID = accountID;
    }

    // copy constructor
    public _Service(_Service serv) {
        this.serviceID = serv.serviceID;
        this.typeOfService = serv.typeOfService;
        this.dateInitiated = serv.dateInitiated;
        this.status = serv.status;
        this.accountID = serv.accountID;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getTypeOfService() {
        return this.typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public LocalDate getDateInitiated() {
        return this.dateInitiated;
    }

    public void setDateInitiated(LocalDate dateInitiated) {
        this.dateInitiated = dateInitiated;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public _Service serviceID(int serviceID) {
        setServiceID(serviceID);
        return this;
    }

    public _Service typeOfService(String typeOfService) {
        setTypeOfService(typeOfService);
        return this;
    }

    public _Service dateInitiated(LocalDate dateInitiated) {
        setDateInitiated(dateInitiated);
        return this;
    }

    public _Service status(String status) {
        setStatus(status);
        return this;
    }

    public _Service accountID(int accountID) {
        setAccountID(accountID);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof _Service)) {
            return false;
        }
        _Service _Service = (_Service) o;
        return serviceID == _Service.serviceID && Objects.equals(typeOfService, _Service.typeOfService) && Objects.equals(dateInitiated, _Service.dateInitiated) && Objects.equals(status, _Service.status) && accountID == _Service.accountID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceID, typeOfService, dateInitiated, status, accountID);
    }

    @Override
    public String toString() {
        return "{" +
            " serviceID='" + getServiceID() + "'" +
            ", typeOfService='" + getTypeOfService() + "'" +
            ", dateInitiated='" + getDateInitiated() + "'" +
            ", status='" + getStatus() + "'" +
            ", accountID='" + getAccountID() + "'" +
            "}";
    }

}
