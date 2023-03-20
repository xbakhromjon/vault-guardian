package uz.bakhromjon.app.application;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase.*;
import uz.bakhromjon.app.common.GenericResponse;
import uz.bakhromjon.app.common.WebAdapter;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
    private final CreateApplicationUseCase createApplicationUseCase;

    @PostMapping
    public GenericResponse<?> create(@RequestBody ApplicationCreateRequest createRequest) {
        return GenericResponse.ok(createApplicationUseCase.execute(createRequest));
    }


}
