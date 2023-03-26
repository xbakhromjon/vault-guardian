package uz.bakhromjon.persistence.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataNotFoundException extends RuntimeException {
    private final Integer statusCode = 400;
    private ErrorData data;

    public DataNotFoundException(String message, ErrorData data) {
        super(message);
        this.data = data;
    }
}
