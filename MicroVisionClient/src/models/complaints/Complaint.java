package models.complaints;

import driver.Driver;
import models.users.Customer;
import utilities.ServerRequest;
import utilities.ServerResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Complaint extends _Complaint {

    private static final long serialVersionUID = -23875608756L;

    public boolean save() {
        boolean complaintCreated = false;

        //Create complaint with user data
        ServerRequest<Complaint> request = new ServerRequest<Complaint>(ServerRequest.COMPLAINT_UPDATE_COMMAND, this);
        Driver.clientConnection.createConnection();
        Driver.clientConnection.configureStreams();
        Driver.clientConnection.sendAction(request);

        ServerResponse response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
            complaintCreated = true;
            System.out.println(response);
        }else {
            System.out.println(response);
        }
        Driver.clientConnection.closeConnection();
        return complaintCreated;
    }

    public void refresh() throws Exception {
        ServerRequest<Complaint> request = new ServerRequest<Complaint>(ServerRequest.COMPLAINT_lOAD_COMMAND,this);
        Driver.clientConnection.createConnection();
        Driver.clientConnection.configureStreams();
        Driver.clientConnection.sendAction(request);

        ServerResponse<Complaint> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.complaintId = ((Complaint) response.getData()).getComplaintId();
            this.status = ((Complaint) response.getData()).getStatus();
            this.details = ((Complaint) response.getData()).getDetails();
            this.typeOfIssue = ((Complaint) response.getData()).getTypeOfIssue();
            this.dateRaised = ((Complaint) response.getData()).getDateRaised();
            this.accountId = ((Complaint) response.getData()).getAccountId();
        }else {
            throw new Exception("Unable to refresh complaint");
        }
        Driver.clientConnection.closeConnection();
    }

    public static ArrayList<Complaint> loadComplaints() {
        //Load complaints from database
        ArrayList<Complaint> complaints = null;
        Integer page = 100;

        ServerRequest<Integer> request = new ServerRequest<Integer>(ServerRequest.COMPLAINT_lOAD_MANY_COMMAND, page);
        Driver.clientConnection.createConnection();
        Driver.clientConnection.configureStreams();
        Driver.clientConnection.sendAction(request);

        ServerResponse<ArrayList<Complaint>> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            complaints = response.getData();
            System.out.println(complaints);
        }else {

        }
        Driver.clientConnection.closeConnection();

        return complaints;
    }

    public boolean delete() {
        boolean complaintDeleted = false;
        ServerRequest<Complaint> request = new ServerRequest<Complaint>(ServerRequest.COMPLAINT_DELETE_COMMAND, this);
        Driver.clientConnection.createConnection();
        Driver.clientConnection.configureStreams();
        Driver.clientConnection.sendAction(request);

        ServerResponse<Integer> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.DELETE_SUCCEEDED) {
            complaintDeleted = true;
        }else {

        }
        return complaintDeleted;
    }

    public Complaint(int complaintId, String status, String details, String typeOfIssue, LocalDateTime dateRaised, int accountId) {
        super(complaintId,status,details,typeOfIssue,dateRaised,accountId);
    }

    public Complaint() {
        super();
    }

}
