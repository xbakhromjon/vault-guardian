package uz.bakhromjon.presentation.password;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.DeletePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.GetPasswordQuery;
import uz.bakhromjon.application.password.application.port.in.UpdatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.criteria.PasswordSearchCriteria;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.common.ERole;
import uz.bakhromjon.presentation.common.CheckRole;
import uz.bakhromjon.presentation.common.Constant;
import uz.bakhromjon.presentation.common.GenericResponse;
import uz.bakhromjon.presentation.common.ValidationMessage;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {
    private final CreatePasswordUseCase createPasswordUseCase;
    private final GetPasswordQuery getPasswordQuery;
    private final DeletePasswordUseCase deletePasswordUseCase;
    private final UpdatePasswordUseCase updatePasswordUseCase;

    @CheckRole(role = ERole.USER)
    @PostMapping
    public GenericResponse<PasswordResponse> create(@RequestBody @Valid CreatePasswordUseCase.PasswordCreateRequest createRequest) {
        return GenericResponse.ok(createPasswordUseCase.create(createRequest));
    }

    @CheckRole(role = ERole.USER)
    @GetMapping("/{passwordId}")
    public GenericResponse<PasswordResponse> get(@PathVariable(name = "passwordId") Long id) {
        return GenericResponse.ok(getPasswordQuery.getById(new Password.PasswordId(id)));
    }


    @CheckRole(role = ERole.USER)
    @DeleteMapping
    public void delete(@RequestParam(name = "passwordId") Long id) {
        deletePasswordUseCase.delete(new Password.PasswordId(id));
    }

    @CheckRole(role = ERole.USER)
    @PutMapping
    public GenericResponse<PasswordResponse> update(@RequestBody UpdatePasswordUseCase.PasswordUpdateRequest updateRequest) {
        return GenericResponse.ok(updatePasswordUseCase.update(updateRequest));
    }

    @CheckRole(role = ERole.USER)
    @GetMapping("/search")
    public GenericResponse<?> search(@RequestParam(required = false, name = "search") String search,
                                     @RequestParam(required = false, name = "page", defaultValue = Constant.PAGE) @Min(value = 0, message = ValidationMessage.PAGE_MIN_VALUE_VIOLATION) Integer page,
                                     @RequestParam(required = false, name = "size", defaultValue = Constant.SIZE) @Min(value = 1, message = ValidationMessage.SIZE_MIN_VALUE_VIOLATION) Integer size) {
        return GenericResponse.ok(getPasswordQuery.search(new PasswordSearchCriteria(search, page, size)));
    }
}
