package uz.bakhromjon.app.application.application.port.out;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import uz.bakhromjon.app.application.domain.Application;

public interface SaveApplicationPort {
    Application save(@Valid @NotNull Application application);
}
