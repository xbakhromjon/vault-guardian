package uz.bakhromjon.presenter.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class GenericResponse<T> extends ResponseEntity<T> {
    private final Long serverTime = System.currentTimeMillis();

    public GenericResponse(T data, HttpStatus status) {
        super(data, status);
    }

    public static <T> GenericResponse<T> ok(T data) {
        return new GenericResponse<>(data, HttpStatus.OK);
    }
}
