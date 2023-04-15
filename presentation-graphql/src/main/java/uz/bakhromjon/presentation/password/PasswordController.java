package uz.bakhromjon.presentation.password;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.GetPasswordQuery;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

@Controller
@RequiredArgsConstructor
public class PasswordController {
    private final GetPasswordQuery getPasswordQuery;
    private final CreatePasswordUseCase createPasswordUseCase;


    @PreAuthorize("isAuthenticated()")
    @QueryMapping
    public PasswordResponse getById(@Argument Long id) {
        return getPasswordQuery.getById(new Password.PasswordId(id));
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "createPassword")
    public PasswordResponse create(@Argument CreatePasswordUseCase.PasswordCreateRequest request) {
        return createPasswordUseCase.create(request);
    }

}
