package uz.bakhromjon.presentation.passport;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.application.port.in.CreatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.DeletePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.GetPassportQuery;
import uz.bakhromjon.application.passport.application.port.in.UpdatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.PassportSearchCriteria;
import uz.bakhromjon.application.passport.application.port.in.PassportResponse;
import uz.bakhromjon.application.passport.domain.Passport;


@Controller
@RequiredArgsConstructor
public class PassportController {
    private final GetPassportQuery getPassportQuery;
    private final CreatePassportUseCase createPassportUseCase;
    private final UpdatePassportUseCase updatePassportUseCase;
    private final DeletePassportUseCase deletePassportUseCase;


    @PreAuthorize("isAuthenticated()")
    @QueryMapping(name = "getOnePassportById")
    public PassportResponse get(@Argument Long id) {
        return getPassportQuery.getById(new Passport.PassportId(id));
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "createPassport")
    public PassportResponse create(@Argument CreatePassportUseCase.PassportCreateRequest request) {
        return createPassportUseCase.create(request);
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "updatePassport")
    public PassportResponse update(@Argument UpdatePassportUseCase.PassportUpdateRequest request) {
        return updatePassportUseCase.update(request);
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping(name = "deletePassport")
    public boolean delete(@Argument Long id) {
        return deletePassportUseCase.delete(new Passport.PassportId(id));
    }

    @PreAuthorize("isAuthenticated()")
    @QueryMapping(name = "searchPassport")
    public PageableResponse<PassportResponse> search(@Argument PassportSearchCriteria criteria) {
        return getPassportQuery.search(criteria);
    }
}
