package uz.bakhromjon.presentation.passport;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.application.passport.application.port.in.CreatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.DeletePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.GetPassportQuery;
import uz.bakhromjon.application.passport.application.port.in.UpdatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.common.ERole;
import uz.bakhromjon.presentation.common.CheckRole;
import uz.bakhromjon.presentation.common.GenericResponse;

import java.util.UUID;

@RestController
@RequestMapping("/passport")
@RequiredArgsConstructor
public class PassportController {
    private final CreatePassportUseCase createPassportUseCase;
    private final GetPassportQuery getPassportQuery;
    private final DeletePassportUseCase deletePassportUseCase;
    private final UpdatePassportUseCase updatePassportUseCase;

    @CheckRole(role = ERole.USER)
    @PostMapping
    public GenericResponse<PassportResponse> create(@RequestBody @Valid CreatePassportUseCase.PassportCreateRequest createRequest) {
        return GenericResponse.ok(createPassportUseCase.create(createRequest));
    }

    @CheckRole(role = ERole.USER)
    @GetMapping("/{passportId}")
    public GenericResponse<PassportResponse> get(@PathVariable Long passportId) {
        return GenericResponse.ok(getPassportQuery.getById(new Passport.PassportId(passportId)));
    }


    @CheckRole(role = ERole.USER)
    @DeleteMapping
    public void delete(@RequestParam(name = "passportId") Long id) {
        deletePassportUseCase.delete(new Passport.PassportId(id));
    }

    @CheckRole(role = ERole.USER)
    @PutMapping
    public GenericResponse<PassportResponse> update(@RequestBody UpdatePassportUseCase.PassportUpdateRequest updateRequest) {
        return GenericResponse.ok(updatePassportUseCase.update(updateRequest));
    }
}
