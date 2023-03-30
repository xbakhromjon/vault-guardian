package uz.bakhromjon.application.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.management.loading.MLetContent;

@Getter
@RequiredArgsConstructor
public enum Error {
    EMAIL_ALREADY_TAKEN(1),
    BAD_CREDENTIALS(2);

    private final Integer code;
}
