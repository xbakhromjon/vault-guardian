package uz.bakhromjon.application.password.application.service;

import org.mapstruct.Mapper;
import uz.bakhromjon.application.common.AES;
import uz.bakhromjon.application.common.ApplicationErrorMessage;
import uz.bakhromjon.application.common.DecryptionException;
import uz.bakhromjon.application.common.EncryptionException;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.UpdatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

@Mapper(componentModel = "spring")
public abstract class PasswordPresenterMapper {
    public Password mapToModel(CreatePasswordUseCase.PasswordCreateRequest createRequest) {
        try {
            String encryptedName = AES.encrypt(createRequest.getName(), AES.getKey());
            String encryptedUsername = AES.encrypt(createRequest.getUsername(), AES.getKey());
            String encryptedPassword = AES.encrypt(createRequest.getPassword(), AES.getKey());
            String encryptedNotes = AES.encrypt(createRequest.getNotes(), AES.getKey());
            return new Password(encryptedName, encryptedUsername, encryptedPassword, encryptedNotes);
        } catch (Exception e) {
            throw new EncryptionException(ApplicationErrorMessage.UNKNOWN_ENCRYPTION_ERROR);
        }
    }

    public Password mapToModel(UpdatePasswordUseCase.PasswordUpdateRequest updateRequest, Password password) {
        try {
            String encryptedName = AES.encrypt(updateRequest.getName(), AES.getKey());
            String encryptedUsername = AES.encrypt(updateRequest.getUsername(), AES.getKey());
            String encryptedPassword = AES.encrypt(updateRequest.getPassword(), AES.getKey());
            String encryptedNotes = AES.encrypt(updateRequest.getNotes(), AES.getKey());

            password.setName(encryptedName);
            password.setUsername(encryptedUsername);
            password.setPassword(encryptedPassword);
            password.setNotes(encryptedNotes);
            return password;
        } catch (Exception e) {
            throw new EncryptionException(ApplicationErrorMessage.UNKNOWN_ENCRYPTION_ERROR);
        }
    }


    public PasswordResponse mapToResponse(Password password) {
        try {
            String decryptedName = AES.decrypt(password.getName(), AES.getKey());
            String decryptedUsername = AES.decrypt(password.getUsername(), AES.getKey());
            String decryptedPassword = AES.decrypt(password.getPassword(), AES.getKey());
            String decryptedNotes = AES.decrypt(password.getNotes(), AES.getKey());
            return new PasswordResponse(password.getId(), password.getCreatedAt(), password.getUpdatedAt(), decryptedName, decryptedUsername, decryptedPassword, decryptedNotes);
        } catch (Exception e) {
            throw new DecryptionException(ApplicationErrorMessage.UNKNOWN_DECRYPTION_ERROR);
        }
    }
}

