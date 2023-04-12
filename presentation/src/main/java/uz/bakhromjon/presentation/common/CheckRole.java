package uz.bakhromjon.presentation.common;

import uz.bakhromjon.common.ERole;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckRole {
    ERole role();
}
