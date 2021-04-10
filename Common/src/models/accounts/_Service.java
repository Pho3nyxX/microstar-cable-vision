package models.accounts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;


// Annotations
@MappedSuperclass
public class _Service implements Serializable {
    public static final String SERVICE_WIRED_INTERNET = "Internet";
    public static final String SERVICE_BROADBAND = "Broadband";
    public static final String SERVICE_TV = "TV";
    public static final String SERVICE_PHONE = "Phone";

    public static final String SERVICE_STATUS_ACTIVE = "Active";
    public static final String SERVICE_STATUS_INACTIVE = "Inactive";
    /**
     *
     */
    private static final long serialVersionUID = -6525110385549761655L;

    /**----------------------------DATA MEMBERS-------------------------------------------- */
    @Id
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


    @Transient
    protected ArrayList<String> validation_errors;


    public boolean validate() {
        boolean valid = true;

        // check if each fields data is valid
        if( !( this.typeOfService.equals(_Service.SERVICE_WIRED_INTERNET) ) && !( this.typeOfService.equals(_Service.SERVICE_BROADBAND) ) && !( this.typeOfService.equals(_Service.SERVICE_TV) ) && !( this.typeOfService.equals(_Service.SERVICE_PHONE) )){
            this.validation_errors.add("Invalid service type entered.");
            valid = false;
        }
        if( (! this.status.equals(SERVICE_STATUS_ACTIVE) ) && (! this.status.equals(SERVICE_STATUS_INACTIVE) ) ){
            this.validation_errors.add("Invalid service status entered.");
            valid = false;
        }
        return valid;
    }

    /**----------------------------CONSTRUCTORS-------------------------------------------- */

    // default constructor
    public _Service() {
        this.serviceID = 0;
        this.typeOfService = "";
        this.dateInitiated = LocalDate.now();
        this.status = "";
        this.accountID = 0;
        this.validation_errors = new ArrayList();
    }

    // primary constructor
    public _Service(int serviceID, String typeOfService, LocalDate dateInitiated, String status, int accountID) {
        this.serviceID = serviceID;
        this.typeOfService = typeOfService;
        this.dateInitiated = dateInitiated;
        this.status = status;
        this.accountID = accountID;
        this.validation_errors = new ArrayList();
    }

    // copy constructor
    public _Service(_Service serv) {
        this.serviceID = serv.serviceID;
        this.typeOfService = serv.typeOfService;
        this.dateInitiated = serv.dateInitiated;
        this.status = serv.status;
        this.accountID = serv.accountID;
        this.validation_errors = new ArrayList();
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

    public ArrayList<String> getValidation_errors() {
        return validation_errors;
    }

    public void setValidation_errors(ArrayList<String> validation_errors) {
        this.validation_errors = validation_errors;
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
