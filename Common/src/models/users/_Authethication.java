package models.users;

public abstract class _Authethication {
     //abstract methods
     public abstract boolean login(String username, String password);
    
     public abstract boolean logout(String userid);
}
