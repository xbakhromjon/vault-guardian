package uz.bakhromjon.persistence.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import uz.bakhromjon.application.common.SessionUserService;

import java.util.Optional;

//@Component
//public class AuditorAwareImpl implements AuditorAware<Long> {
//    @Autowired
//    private SessionUserService sessionUserService;
//
//    @Override
//    public Optional<Long> getCurrentAuditor() {
//        return Optional.ofNullable(sessionUserService.getSessionId().getValue());
//    }
//}
