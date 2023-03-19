package uz.bakhromjon.app.application.application.port.out;

import uz.bakhromjon.app.application.domain.Application;

public interface SaveApplicationPort {
    Application execute(Application application);
}
