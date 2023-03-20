package uz.bakhromjon.app.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorResponse implements Serializable {
    private String error;

    private String path;

    private String message;

    private Object data;


    public ErrorResponse(String error, String path, String message, Object data) {
        setError(error);
        setPath(path);
        setMessage(message);
        setData(data);
    }
}
