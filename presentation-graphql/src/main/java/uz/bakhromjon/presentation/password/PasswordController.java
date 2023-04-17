package uz.bakhromjon.presentation.password;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.DeletePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.GetPasswordQuery;
import uz.bakhromjon.application.password.application.port.in.UpdatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.criteria.PasswordSearchCriteria;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

@Controller
@RequiredArgsConstructor
public class PasswordController {
    private final GetPasswordQuery getPasswordQuery;
    private final CreatePasswordUseCase createPasswordUseCase;
    private final UpdatePasswordUseCase updatePasswordUseCase;
    private final DeletePasswordUseCase deletePasswordUseCase;


    @PreAuthorize("isAuthenticated()")
    @QueryMapping(name = "getOnePasswordById")
    public PasswordResponse get(@Argument Long id) {
        return getPasswordQuery.getById(new Password.PasswordId(id));
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "createPassword")
    public PasswordResponse create(@Argument CreatePasswordUseCase.PasswordCreateRequest request) {
        return createPasswordUseCase.create(request);
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "updatePassword")
    public PasswordResponse update(@Argument UpdatePasswordUseCase.PasswordUpdateRequest request) {
        return updatePasswordUseCase.update(request);
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "deletePassword")
    public boolean delete(@Argument Long id) {
        return deletePasswordUseCase.delete(new Password.PasswordId(id));
    }

    @PreAuthorize("isAuthenticated()")
    @QueryMapping(name = "searchPassword")
    public PageableResponse<PasswordResponse> search(@Argument PasswordSearchCriteria criteria) {
        return getPasswordQuery.search(criteria);
    }
}
