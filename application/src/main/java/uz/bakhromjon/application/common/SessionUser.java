package uz.bakhromjon.application.common;

public interface SessionUser {
    Long getId();

    String getEmail();

    String getMasterPassword();

    String getHint();
}
