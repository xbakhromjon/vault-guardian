package uz.bakhromjon.application.common;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

public class AES {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final int KEY_SIZE = 128;
    private static final String KEYSTORE_TYPE = "JCEKS";
    private static final String KEYSTORE_PASSWORD = "myKeystorePassword";
    private static final String KEY_ALIAS = "mySecretKeyAlias";
    public static final String KEY_PASSWORD = "mySecretKeyPassword";

    public static void main(String[] args) throws Exception {
        String plaintext = "This is sensitive data!";

        // Generate or load the key from the keystore
        SecretKey key = getKey();

        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + ciphertext);

        // Decrypt the ciphertext
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public static SecretKey getKey() throws Exception {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        File keystoreFile = new File("configuration/src/main/resources/keystore");
        if (keystoreFile.exists()) {
            try (FileInputStream fis = new FileInputStream(keystoreFile)) {
                keyStore.load(fis, KEYSTORE_PASSWORD.toCharArray());
            }
        } else {
            keyStore.load(null, null);
        }

        // Check if the key exists in the keystore
        if (keyStore.containsAlias(KEY_ALIAS)) {
            // Get the key from the keystore
            return (SecretKey) keyStore.getKey(KEY_ALIAS, KEY_PASSWORD.toCharArray());
        } else {
            // Generate a new key and store it in the keystore
            SecretKey key = generateKey();
            KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(key);
            KeyStore.PasswordProtection protection = new KeyStore.PasswordProtection(KEY_PASSWORD.toCharArray());
            keyStore.setEntry(KEY_ALIAS, entry, protection);
            try (FileOutputStream fos = new FileOutputStream(keystoreFile)) {
                keyStore.store(fos, KEYSTORE_PASSWORD.toCharArray());
            }
            return key;
        }
    }

    private static SecretKey generateKey() throws Exception {
        // Generate a random key
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(KEY_SIZE, SecureRandom.getInstanceStrong());
        return keyGenerator.generateKey();
    }

    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        if (Objects.isNull(plaintext)) return null;
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] ciphertextBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertextBytes);
    }

    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        if (Objects.isNull(ciphertext)) return null;
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
        byte[] plaintextBytes = cipher.doFinal(ciphertextBytes);
        return new String(plaintextBytes);
    }
}
