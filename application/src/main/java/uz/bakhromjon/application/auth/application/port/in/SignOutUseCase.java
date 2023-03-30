package uz.bakhromjon.application.auth.application.port.in;

public interface SignOutUseCase {
    Void signOut(String token);
}
