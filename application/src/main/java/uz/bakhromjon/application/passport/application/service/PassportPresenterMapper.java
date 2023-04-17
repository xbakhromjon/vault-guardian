package uz.bakhromjon.application.passport.application.service;

import org.mapstruct.Mapper;
import uz.bakhromjon.application.common.AES;
import uz.bakhromjon.application.common.ApplicationErrorMessage;
import uz.bakhromjon.application.common.DecryptionException;
import uz.bakhromjon.application.common.EncryptionException;
import uz.bakhromjon.application.passport.application.port.in.CreatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.UpdatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;
import uz.bakhromjon.application.passport.domain.Passport;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class PassportPresenterMapper {
    public Passport mapToModel(CreatePassportUseCase.PassportCreateRequest createRequest) {
        try {
            SecretKey key = AES.getKey();
            String encryptedName = AES.encrypt(createRequest.getName(), key);
            String encryptedCountry = AES.encrypt(createRequest.getCountry(), key);
            String encryptedNumber = AES.encrypt(createRequest.getNumber(), key);
            String encryptedSex = AES.encrypt(createRequest.getSex(), key);
            String encryptedNationality = AES.encrypt(createRequest.getNationality(), key);
            String encryptedIssuingAuthority = AES.encrypt(createRequest.getIssuingAuthority(), key);
            String encryptedNotes = AES.encrypt(createRequest.getNotes(), key);

            return new Passport(encryptedName, encryptedCountry, encryptedNumber,
                    encryptedSex, encryptedNationality, encryptedIssuingAuthority,
                    createRequest.getDateOfBirth(), createRequest.getIssuedDate(), createRequest.getExpirationDate(),
                    encryptedNotes);
        } catch (Exception e) {
            throw new EncryptionException(ApplicationErrorMessage.UNKNOWN_ENCRYPTION_ERROR);
        }
    }

    public Passport mapToModel(UpdatePassportUseCase.PassportUpdateRequest updateRequest, Passport passport) {
        try {
            SecretKey key = AES.getKey();
            String encryptedName = AES.encrypt(updateRequest.getName(), key);
            String encryptedCountry = AES.encrypt(updateRequest.getCountry(), key);
            String encryptedNumber = AES.encrypt(updateRequest.getNumber(), key);
            String encryptedSex = AES.encrypt(updateRequest.getSex(), key);
            String encryptedNationality = AES.encrypt(updateRequest.getNationality(), key);
            String encryptedIssuingAuthority = AES.encrypt(updateRequest.getIssuingAuthority(), key);
            String encryptedNotes = AES.encrypt(updateRequest.getNotes(), key);

            passport.setName(encryptedName);
            passport.setCountry(encryptedCountry);
            passport.setNumber(encryptedNumber);
            passport.setSex(encryptedSex);
            passport.setNationality(encryptedNationality);
            passport.setIssuingAuthority(encryptedIssuingAuthority);
            passport.setDateOfBirth(updateRequest.getDateOfBirth());
            passport.setIssuedDate(updateRequest.getIssuedDate());
            passport.setExpirationDate(updateRequest.getExpirationDate());
            passport.setNotes(encryptedNotes);
            return passport;
        } catch (Exception e) {
            throw new EncryptionException(ApplicationErrorMessage.UNKNOWN_ENCRYPTION_ERROR);
        }
    }


    public PassportResponse mapToResponse(Passport passport) {
        try {
            SecretKey key = AES.getKey();
            String decryptedName = AES.decrypt(passport.getName(), key);
            String decryptedCountry = AES.decrypt(passport.getCountry(), key);
            String decryptedNumber = AES.decrypt(passport.getNumber(), key);
            String decryptedSex = AES.decrypt(passport.getSex(), key);
            String decryptedNationality = AES.decrypt(passport.getNationality(), key);
            String decryptedIssuingAuthority = AES.decrypt(passport.getIssuingAuthority(), key);
            String decryptedNotes = AES.decrypt(passport.getNotes(), key);


            return new PassportResponse(passport.getId(), passport.getCreatedAt(), passport.getUpdatedAt(),
                    decryptedName, decryptedCountry, decryptedNumber, decryptedSex,
                    decryptedNationality, decryptedIssuingAuthority,
                    passport.getDateOfBirth(), passport.getIssuedDate(),
                    passport.getExpirationDate(), decryptedNotes
            );
        } catch (Exception e) {
            throw new DecryptionException(ApplicationErrorMessage.UNKNOWN_DECRYPTION_ERROR);
        }
    }

    public List<PassportResponse> mapToResponse(Collection<Passport> source) {
        if (Objects.isNull(source)) return null;
        return source.stream().map(this::mapToResponse).toList();
    }
}

