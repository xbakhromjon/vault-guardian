package uz.bakhromjon.presentation.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationMessage {
    public static final String PAGE_MIN_VALUE_VIOLATION = "page_min_value_violation";
    public static final String SIZE_MIN_VALUE_VIOLATION = "size_min_value_violation";
}
