package uz.bakhromjon.persistence.common;

import lombok.Getter;
import uz.bakhromjon.common.ClientException;
import uz.bakhromjon.common.ErrorData;

@Getter
public class DataNotFoundException extends ClientException {

    public DataNotFoundException(String message, ErrorData data) {
        super(message, 404, data);
    }
}
