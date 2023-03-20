package uz.bakhromjon.app.application.application.port.out;

import jakarta.validation.constraints.NotNull;
import uz.bakhromjon.app.application.domain.Application;

public interface LoadApplicationPort {
    Application loadById(@NotNull Long applicationId);
}
