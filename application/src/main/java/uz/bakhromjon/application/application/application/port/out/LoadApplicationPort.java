package uz.bakhromjon.application.application.application.port.out;

import jakarta.validation.constraints.NotNull;
import uz.bakhromjon.application.application.domain.Application;

public interface LoadApplicationPort {
    Application loadById(@NotNull Long applicationId);
}
