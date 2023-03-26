package uz.bakhromjon.application.application.application.port.in;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;

@Validated
public interface GetApplicationQuery {
    ApplicationResponse execute(@NotNull Long applicationId);
}
