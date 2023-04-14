package uz.bakhromjon.presentation.password;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uz.bakhromjon.application.password.application.port.in.GetPasswordQuery;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

@Controller
@RequiredArgsConstructor
public class PasswordController {
    private final GetPasswordQuery getPasswordQuery;

    @QueryMapping
    public PasswordResponse getById(@Argument Long id) {
        return getPasswordQuery.getById(new Password.PasswordId(id));
    }
}
