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

import javax.crypto.SecretKey;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class PasswordPresenterMapper {
    public Password mapToModel(CreatePasswordUseCase.PasswordCreateRequest source) {
        try {
            SecretKey key = AES.getKey();
            String encryptedName = AES.encrypt(source.getName(), key);
            String encryptedUsername = AES.encrypt(source.getUsername(), key);
            String encryptedPassword = AES.encrypt(source.getPassword(), key);
            String encryptedNotes = AES.encrypt(source.getNotes(), key);
            return new Password(encryptedName, encryptedUsername, encryptedPassword, encryptedNotes);
        } catch (Exception e) {
            throw new EncryptionException(ApplicationErrorMessage.UNKNOWN_ENCRYPTION_ERROR);
        }
    }

    public Password mapToModel(UpdatePasswordUseCase.PasswordUpdateRequest source, Password target) {
        try {
            SecretKey key = AES.getKey();
            String encryptedName = AES.encrypt(source.getName(), key);
            String encryptedUsername = AES.encrypt(source.getUsername(), key);
            String encryptedPassword = AES.encrypt(source.getPassword(), key);
            String encryptedNotes = AES.encrypt(source.getNotes(), key);

            target.setName(encryptedName);
            target.setUsername(encryptedUsername);
            target.setPassword(encryptedPassword);
            target.setNotes(encryptedNotes);
            return target;
        } catch (Exception e) {
            throw new EncryptionException(ApplicationErrorMessage.UNKNOWN_ENCRYPTION_ERROR);
        }
    }


    public PasswordResponse mapToResponse(Password source) {
        try {
            SecretKey key = AES.getKey();
            String decryptedName = AES.decrypt(source.getName(), key);
            String decryptedUsername = AES.decrypt(source.getUsername(), key);
            String decryptedPassword = AES.decrypt(source.getPassword(), key);
            String decryptedNotes = AES.decrypt(source.getNotes(), key);
            return new PasswordResponse(source.getId(), source.getCreatedAt(), source.getUpdatedAt(), decryptedName, decryptedUsername, decryptedPassword, decryptedNotes);
        } catch (Exception e) {
            throw new DecryptionException(ApplicationErrorMessage.UNKNOWN_DECRYPTION_ERROR);
        }
    }


    public List<PasswordResponse> mapToResponse(List<Password> source) {
        if (Objects.isNull(source)) return null;
        return source.stream().map(this::mapToResponse).toList();
    }
}

