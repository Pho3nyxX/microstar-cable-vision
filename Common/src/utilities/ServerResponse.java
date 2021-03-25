package utilities;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable{
    String message;
    String code;
    T data;
}
