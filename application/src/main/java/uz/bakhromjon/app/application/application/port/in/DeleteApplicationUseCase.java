package uz.bakhromjon.app.application.application.port.in;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface DeleteApplicationUseCase {
    boolean execute(@NotNull Long applicationId);
}
