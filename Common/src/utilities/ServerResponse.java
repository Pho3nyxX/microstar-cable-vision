package utilities;

import java.io.Serializable;
import java.util.Objects;

public class ServerResponse<T> implements Serializable{
    /**---------------------RESPONSE CODES------------------------ */
    public static final int DELETE_FAILED = 1;
    public static final int DELETE_SUCCEEDED = 2;
    public static final int SAVE_FAILED = 1;
    public static final int SAVE_SUCCEEDED = 1;
    public static final int REQUEST_FAILED = 200;
    public static final int REQUEST_SUCCEEDED = 404;
    public static final int ONLINE_AVAILABLE = 500;

    
    /**----------------------DATA MEMBERS------------------------ */
    String message;
    int code;
    T data;
    

    /**----------------------CONSTRUCTORS------------------------ */
    public ServerResponse() {
    }
    
    public ServerResponse(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
    

    /**----------------------GETTERS & SETTERS------------------------ */
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    /**----------------------FLUENT GETTERS & SETTERS------------------------ */
    public ServerResponse<T> message(String message) {
        setMessage(message);
        return this;
    }
    
    public ServerResponse<T> code(int code) {
        setCode(code);
        return this;
    }
    
    public ServerResponse<T> data(T data) {
        setData(data);
        return this;
    }
    
    /**----------------------EQUALS HASHCODE & TOSTRING------------------------ */
    @Override
    public boolean equals(Object o) {
        if (o == this)
        return true;
        if (!(o instanceof ServerResponse)) {
            return false;
        }
        ServerResponse<T> serverResponse = (ServerResponse<T>) o;
        return Objects.equals(message, serverResponse.message) && Objects.equals(code, serverResponse.code) && Objects.equals(data, serverResponse.data);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(message, code, data);
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", code='" + getCode() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }
}
