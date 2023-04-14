package uz.bakhromjon.presentation.application;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.application.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.DeleteApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.GetApplicationQuery;
import uz.bakhromjon.application.application.application.port.in.UpdateApplicationUseCase;
import uz.bakhromjon.presentation.common.GenericResponse;
import uz.bakhromjon.common.WebAdapter;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
@Validated
public class ApplicationController {
    private final CreateApplicationUseCase createApplicationUseCase;
    private final GetApplicationQuery getApplicationQuery;
    private final UpdateApplicationUseCase updateApplicationUseCase;
    private final DeleteApplicationUseCase deleteApplicationUseCase;

    @PostMapping
    public GenericResponse<?> create(@RequestBody CreateApplicationUseCase.ApplicationCreateRequest createRequest) {
        return GenericResponse.ok(createApplicationUseCase.execute(createRequest));
    }

    @GetMapping("/{applicationId}")
    public GenericResponse<?> get(@PathVariable @NotNull Long applicationId) {
        return GenericResponse.ok(getApplicationQuery.execute(applicationId));
    }

    @PutMapping
    public GenericResponse<?> update(@RequestBody UpdateApplicationUseCase.ApplicationUpdateRequest updateRequest) {
        return GenericResponse.ok(updateApplicationUseCase.execute(updateRequest));
    }

    @DeleteMapping
    public GenericResponse<?> delete(@RequestParam @NotNull Long applicationId) {
        return GenericResponse.ok(deleteApplicationUseCase.execute(applicationId));
    }
}
