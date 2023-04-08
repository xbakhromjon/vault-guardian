package uz.bakhromjon.presentation.password;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.DeletePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.GetPasswordQuery;
import uz.bakhromjon.application.password.application.port.in.UpdatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.presentation.common.GenericResponse;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {
    private final CreatePasswordUseCase createPasswordUseCase;
    private final GetPasswordQuery getPasswordQuery;
    private final DeletePasswordUseCase deletePasswordUseCase;
    private final UpdatePasswordUseCase updatePasswordUseCase;

    @PostMapping
    public GenericResponse<PasswordResponse> create(@RequestBody @Valid CreatePasswordUseCase.PasswordCreateRequest createRequest) {
        return GenericResponse.ok(createPasswordUseCase.create(createRequest));
    }

    @GetMapping("/{passwordId}")
    public GenericResponse<PasswordResponse> get(@PathVariable Long passwordId) {
        return GenericResponse.ok(getPasswordQuery.getById(passwordId));
    }


    @DeleteMapping
    public void delete(@RequestParam Long passwordId) {
        deletePasswordUseCase.delete(passwordId);
    }

    @PutMapping
    public GenericResponse<PasswordResponse> update(@RequestBody UpdatePasswordUseCase.PasswordUpdateRequest updateRequest) {
        return GenericResponse.ok(updatePasswordUseCase.update(updateRequest));
    }
}
