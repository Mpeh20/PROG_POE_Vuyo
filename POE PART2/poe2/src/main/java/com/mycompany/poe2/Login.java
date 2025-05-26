/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe2;

/**
 *
 * @author RC_Student_lab
 */


    public class Login {
        
    private static String savedUsername;                                        // Instance variables
    private String savedPassword;
    
    public Login(String username, String password, String phone) {              // Constructor

        savedUsername = username;
        this.savedPassword = password;
    }

    public static boolean isUsernameValid(String username) {                    // Check if the username is valid (contains "_" and max 5 characters)
        return username.length() <= 5 && username.contains("_");
    }

    public static boolean isPasswordStrong(String password) {                   // Check if the password is strong (min 8 chars, 1 capital, 1 digit, 1 special)
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#_$%^&*()].*");
    }

    public static boolean isPhoneValid(String phone) {                           // Check if the phone number is valid (starts with +27 and has 10 digits after)
        return phone.matches("^\\+27\\d{9}$");
    }

    public String register(String username, String password, String phone) {    // Attempt to register the user
        if (!isUsernameValid(username)) {
            return "Username is invalid. It must contain an underscore and be no more than 5 characters.";
        }

        if (!isPasswordStrong(password)) {
            return "Password is weak. It must be at least 8 characters, with a capital letter, a number, and a special character.";
        }

        if (!isPhoneValid(phone)) {
            return "Phone number format is incorrect. It should start with +27 followed by 9 digits.";
        }

        savedUsername = username;
        savedPassword = password;

        return "User registered successfully.";
    }

    public boolean authenticate(String inputUsername, String inputPassword) {   // Validate login credentials
        return inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword);
    }

    public String getLoginMessage(String inputUsername, String inputPassword) { // Return a login message
        if (authenticate(inputUsername, inputPassword)) {
            return "Welcome , it's great to see you again!";
        } else {
            return "Incorrect username or password. Please try again.";
        }
    }

    boolean authenticate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


