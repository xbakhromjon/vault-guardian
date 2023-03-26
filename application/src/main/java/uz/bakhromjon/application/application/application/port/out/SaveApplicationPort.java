package uz.bakhromjon.application.application.application.port.out;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import uz.bakhromjon.application.application.domain.Application;

public interface SaveApplicationPort {
    Application save(@Valid @NotNull Application application);
}
