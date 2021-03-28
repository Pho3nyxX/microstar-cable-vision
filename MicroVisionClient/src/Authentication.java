import models.users._Authethication;
import models.users._User;
import utilities.ServerRequest;
import utilities.ServerResponse;

public class Authentication extends _Authethication {
    @Override
    public boolean login(String username, String password) {
        _User user = new Customer();
        boolean loggedIn = false;
        user.setUsername(username);
        user.setPassword(password);
        //cerate request object to send to server
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_LOGIN_COMMAND, user); 
        App.clientConnection.sendAction(request);
        // TODO: Check if user was logged in
        ServerResponse response = App.clientConnection.receiveResponse();
        if(response.getCode().equals(ServerResponse.USER_LOGIN_SUCCESSFUL_RESPONSE)){
            //request.setCommand(ServerRequest.USER_GET_LOGGED_IN_COMMAND);
            //App.clientConnection.sendAction(request);
            App.sessionId = response.getData().toString(); 
            loggedIn = true;
            System.out.println(response);
        }
        App.clientConnection.closeConnection();

        return loggedIn;
    }

    @Override
    public boolean logout(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
