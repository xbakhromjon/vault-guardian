package uz.bakhromjon.app.common.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author : Ahrorjon Isroilov
 **/
@Getter
public class UnauthorizedException extends RuntimeException {
    private Object data;
    private Integer status = HttpStatus.UNAUTHORIZED.value();

    public UnauthorizedException(String message, Object data) {
        super(message);
        this.data = data;
    }
}
