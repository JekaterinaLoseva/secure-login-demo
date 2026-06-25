package com.demo.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * GOOD PRACTICE: Secure authentication using hashing and salting (IAM Basics).
 */
public class SecureAuth {

    // Generates a cryptographically strong random salt for a new user
    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Hashes the password combined with the unique salt using SHA-256
    public String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // Securely verifies the input password against the stored database hash
    public boolean verifyUserPassword(String inputPassword, String storedHash, byte[] storedSalt)
            throws NoSuchAlgorithmException {
        String newHash = hashPassword(inputPassword, storedSalt);
        return newHash.equals(storedHash);
    }
}
