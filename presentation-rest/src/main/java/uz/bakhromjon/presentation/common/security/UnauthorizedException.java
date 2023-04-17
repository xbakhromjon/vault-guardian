package uz.bakhromjon.presentation.common.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;

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
