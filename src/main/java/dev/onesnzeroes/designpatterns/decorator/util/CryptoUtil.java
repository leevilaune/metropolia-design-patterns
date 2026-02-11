package dev.onesnzeroes.designpatterns.decorator.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/*
source: https://pi6eon.medium.com/simple-java-native-encryption-decryption-c971cb8f1c06
 */
public class CryptoUtil {
    private static final String ALGORITHM = "AES";
    public static String encrypt(String secretKey, String decryptedText) throws Exception {
        SecretKeySpec KEY_SPEC = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, KEY_SPEC);
        byte[] encrypted = cipher.doFinal(decryptedText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
    public static String decrypt(String secretKey, String encryptedText) throws Exception {
        SecretKeySpec KEY_SPEC = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, KEY_SPEC);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decrypted);
    }
}