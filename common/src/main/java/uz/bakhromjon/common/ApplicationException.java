package uz.bakhromjon.common;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final Integer status;
    private final ErrorData data;

    public ApplicationException(String message, Integer status, ErrorData data) {
        super(message);
        this.status = status;
        this.data = data;
    }
}
