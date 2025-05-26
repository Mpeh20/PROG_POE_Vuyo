/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe2;

/**
 *
 * @author RC_Student_lab
 */


   
    import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.*;

 public class Poe2 {
    static String registeredName;
    static String registeredSurname;
    static String registeredUsername;
    static String registeredCell;
    static String registeredPassword;

    static ArrayList<String> sentMessages = new ArrayList<>();

    public static void main(String[] args) {
        registerUser();
        if (loginUser()) {
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Too many failed attempts. Exiting...");
        }
    }

    // Registration
    private static void registerUser() {
        registeredName = JOptionPane.showInputDialog("Enter your Name:");
        registeredSurname = JOptionPane.showInputDialog("Enter your Surname:");

        while (true) {
            registeredUsername = JOptionPane.showInputDialog("Create a Username (must be 5 characters, include an underscore and a digit):");
            if (isValidUsername(registeredUsername)) break;
            JOptionPane.showMessageDialog(null, "Invalid username. Must be 5 characters long, contain an underscore and a digit.");
        }

        while (true) {
            registeredCell = JOptionPane.showInputDialog("Enter your Cell Number (Format: +27XXXXXXXXX):");
            if (isValidCellNumber(registeredCell)) break;
            JOptionPane.showMessageDialog(null, "Invalid cell number. Must start with +27 and be followed by 9 digits.");
        }

        while (true) {
            registeredPassword = JOptionPane.showInputDialog("Create a Password (8+ chars, 1 uppercase, 1 digit, 1 special char):");
            if (isValidPassword(registeredPassword)) break;
            JOptionPane.showMessageDialog(null, "Invalid password. Must be 8+ characters, with 1 uppercase, 1 digit, 1 special character.");
        }

        JOptionPane.showMessageDialog(null, "Registration successful!");
    }

    // Login
    private static boolean loginUser() {
        int attempts = 0;
        while (attempts < 3) {
            String username = JOptionPane.showInputDialog("Login - Enter Username:");
            String cell = JOptionPane.showInputDialog("Enter Cell Number:");
            String password = JOptionPane.showInputDialog("Enter Password:");

            if (username.equals(registeredUsername) &&
                cell.equals(registeredCell) &&
                password.equals(registeredPassword)) {

                JOptionPane.showMessageDialog(null, "Login successful!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect login. Try again.");
                attempts++;
            }
        }
        return false;
    }

    // Main menu
    private static void showMenu() {
        while (true) {
            String[] options = {"Enter Message", "Disregard Message", "Check Previous Messages", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Main Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0 -> enterMessage();
                case 1 -> JOptionPane.showMessageDialog(null, "Message disregarded.");
                case 2 -> viewMessages();
                case 3, JOptionPane.CLOSED_OPTION -> {
                    JOptionPane.showMessageDialog(null, "Exiting program.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid choice.");
            }
        }
    }

    // Message entry
    private static void enterMessage() {
        String message = JOptionPane.showInputDialog("Enter your message:");
        if (message != null && !message.trim().isEmpty()) {
            sentMessages.add(message);
            JOptionPane.showMessageDialog(null, "Message sent!");
        } else {
            JOptionPane.showMessageDialog(null, "No message entered.");
        }
    }

    // View sent messages
    private static void viewMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent.");
        } else {
            StringBuilder sb = new StringBuilder("Sent Messages:\n");
            for (int i = 0; i < sentMessages.size(); i++) {
                sb.append((i + 1)).append(". ").append(sentMessages.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // Validations
    private static boolean isValidUsername(String username) {
        return username != null && username.length() == 5 &&
               username.contains("_") &&
               username.matches(".*\\d.*");
    }

    private static boolean isValidCellNumber(String cell) {
        return cell != null && cell.matches("\\+27\\d{9}");
    }

    private static boolean isValidPassword(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}

