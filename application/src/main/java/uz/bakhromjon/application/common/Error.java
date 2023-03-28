package uz.bakhromjon.application.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Error {
    EMAIL_ALREADY_TAKEN(1);

    private final Integer code;
}
