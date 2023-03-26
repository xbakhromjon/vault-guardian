package uz.bakhromjon.application.user.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.user.application.port.in.CreateUserUseCase;
import uz.bakhromjon.application.user.application.port.out.SaveUserPort;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final UserPresenterMapper USER_PRESENTER_MAPPER = UserPresenterMapper.INSTANCE;
    private final SaveUserPort saveUserPort;

    @Override
    public User create(UserCreateRequest createRequest) {
        User user = USER_PRESENTER_MAPPER.mapToModel(createRequest);
        user = saveUserPort.save(user);
        return user;
    }
}
