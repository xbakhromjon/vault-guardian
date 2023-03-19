package uz.bakhromjon.app.application.application.port.out;

import uz.bakhromjon.app.application.domain.Application;

public interface LoadApplicationPort {
    Application loadById(Long applicationId);
}
