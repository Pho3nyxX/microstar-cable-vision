package utilities;

import java.io.Serializable;

public class ServerRequest<T> implements Serializable{
    String command;
    T data;
}
