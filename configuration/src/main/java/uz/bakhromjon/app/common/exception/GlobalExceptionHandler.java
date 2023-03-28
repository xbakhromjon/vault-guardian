package uz.bakhromjon.app.common.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import uz.bakhromjon.common.ClientException;
import uz.bakhromjon.common.UserException;
import uz.bakhromjon.persistence.common.DataNotFoundException;
import uz.bakhromjon.presentation.common.GenericResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientException.class)
    public GenericResponse<ErrorResponse> customRuntimeException(ClientException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getMessage(),
                        e.getData()
                ),
                HttpStatus.valueOf(e.getStatus())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericResponse<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getBody().getDetail(),
                        e.getDetailMessageArguments()
                ),
                HttpStatus.valueOf(e.getStatusCode().value())
        );
    }

    @ExceptionHandler(UserException.class)
    public GenericResponse<ErrorResponse> userException(UserException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getMessage(),
                        e.getData(),
                        e.getCode()
                ),
                HttpStatus.valueOf(e.getStatus())
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public GenericResponse<ErrorResponse> constraintViolationException(ConstraintViolationException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getLocalizedMessage(),
                        e.getMessage()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public GenericResponse<ErrorResponse> defaultException(Exception e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getLocalizedMessage(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


}
