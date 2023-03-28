package uz.bakhromjon.common;

import lombok.Getter;

import java.io.IOException;

@Getter
public class UserException extends IOException {
    private Integer status;
    private Integer code;
    private ErrorData data;

    public UserException(String message, Integer status, Integer code, ErrorData data) {
        super(message);
        this.status = status;
        this.code = code;
        this.data = data;
    }
}
