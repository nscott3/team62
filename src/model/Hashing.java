package model;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class Hashing {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static byte[] generateSalt() {
        byte[] bytes = new byte[64];
        RANDOM.nextBytes(bytes);
        return bytes;
    }

    public static byte[] generateHash(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(password.getBytes(StandardCharsets.UTF_8));
            md.update(salt);

            return md.digest();

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean compareHashes(byte[] hash1, byte[] hash2) {
        return Arrays.equals(hash1, hash2);
    }
}
