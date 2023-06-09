package uz.bakhromjon.app.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataNotFoundException extends RuntimeException {
    private final Integer statusCode = 400;
    private Object data;

    public DataNotFoundException(String message, Object data) {
        super(message);
        this.data = data;
    }
}
