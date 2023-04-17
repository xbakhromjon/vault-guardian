package uz.bakhromjon.presentation.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String error;

    private String path;

    private String message;

    private Object data;
    private Integer code;


    public ErrorResponse(String error, String path, String message, Object data) {
        setError(error);
        setPath(path);
        setMessage(message);
        setData(data);
    }
}
