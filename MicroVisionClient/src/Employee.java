
import models.users.*;
import utilities.*;
import models.chat._Message;

public class Employee extends _Employee{


    @Override
    public boolean save() {
        boolean userCreated = false; 
        // Create request with user data
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_REGISTER_COMMAND, this); 
        App.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse response = App.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
            userCreated = true; 
            
            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed 
            //Add error returned from server to validation errors array
            this.validation_errors.add(response.getMessage());
        }
        App.clientConnection.closeConnection();
        return userCreated;
    }

    public void refresh() throws Exception{ //TODO update with custom exceptions
        //TODO: refresh userdata from server
        ServerRequest<Employee> request = new ServerRequest<Employee>(ServerRequest.USER_LOAD_COMMAND, this); 
        App.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<Employee> response = App.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.userID = ((Employee)response.getData()).getUserID();
            this.age = ((Employee)response.getData()).getAge();
            this.role = ((Employee)response.getData()).getRole();
            this.phone = ((Employee)response.getData()).getPhone();
            this.username = ((Employee)response.getData()).getUsername();
            this.firstName = ((Employee)response.getData()).getfirstName();
            this.lastName = ((Employee)response.getData()).getlastName();
            this.middleName = ((Employee)response.getData()).getmiddleName();
            
            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }
        App.clientConnection.closeConnection();
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        boolean userDeleted = false;
        ServerRequest<Employee> request = new ServerRequest<Employee>(ServerRequest.USER_DELETE_COMMAND , this); 
        App.clientConnection.sendAction(request);
        ServerResponse<Integer> response = App.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.DELETE_SUCCEEDED) {
            userDeleted = true;
            //TODO handle user creation succeed
        }else{
            this.validation_errors.add("User delete failed.");
        }
        return userDeleted;
    }

/**------------------------THIS NEEDS TO MOVE TO A LIVECHAT CONTROLLER
*/
    public void liveChat (_Message message) {
        //Login to live chat

        ServerRequest<_Message> request = new ServerRequest<_Message>(ServerRequest.USER_LIVE_CHAT_COMMAND, ) {
        });
        App.messageConnection.sendAction(request);
    }

}
