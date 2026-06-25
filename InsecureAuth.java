package com.demo.auth;

/**
 * BAD PRACTICE: Plain-text password authentication.
 * Highly vulnerable to data leaks and brute-force attacks.
 */
public class InsecureAuth {

    public boolean loginUser(String inputPassword, String storedPasswordFromDB) {
        // DANGER: Comparing plain-text strings directly.
        // If the database is leaked, all user passwords are exposed.
        return inputPassword.equals(storedPasswordFromDB);
    }
}
