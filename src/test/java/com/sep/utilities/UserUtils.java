package com.sep.utilities;

/**
 * Utility class for creating user email addresses.
 */
public class UserUtils {

    private static final String DOMAIN = "@oeshoen9.mailosaur.net";

    /**
     * Creates a user email address based on the given first and last names.
     *
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @return the user email address
     * @throws IllegalArgumentException if the first name or last name is null
     */
    public static String createUserEmail(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First name or last name cannot be null");
        }

        String email = firstName.toLowerCase() + lastName.toLowerCase() + DOMAIN;
        return email;
    }

}
