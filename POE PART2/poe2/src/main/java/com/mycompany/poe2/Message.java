/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe2;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.*;
import java.util.ArrayList;

public class Message {
    static String registeredName;
    static String registeredSurname;
    static String registeredUsername;
    static String registeredCell;
    static String registeredPassword;

    static ArrayList<String> sentMessages = new ArrayList<>();

    public static void main(String[] args) {
        registerUser();

        // Create Login instance and authenticate
        Login login = new Login(registeredUsername, registeredCell, registeredPassword);
        if (login.authenticate()) {
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Too many failed attempts. Exiting...");
        }
    }

    private static void registerUser() {
        registeredName = JOptionPane.showInputDialog("Enter your Name:");
        registeredSurname = JOptionPane.showInputDialog("Enter your Surname:");

        while (true) {
            registeredUsername = JOptionPane.showInputDialog("Create a Username (5 chars, include _ and digit):");
            if (isValidUsername(registeredUsername)) break;
            JOptionPane.showMessageDialog(null, "Invalid username.");
        }

        while (true) {
            registeredCell = JOptionPane.showInputDialog("Enter Cell Number (+27 followed by 10 digits):");
            if (isValidCellNumber(registeredCell)) break;
            JOptionPane.showMessageDialog(null, "Invalid cell number.");
        }

        while (true) {
            registeredPassword = JOptionPane.showInputDialog("Create Password (8+ chars, 1 uppercase, 1 digit, 1 special char):");
            if (isValidPassword(registeredPassword)) break;
            JOptionPane.showMessageDialog(null, "Invalid password.");
        }

        JOptionPane.showMessageDialog(null, "Registration successful!");
    }

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

    private static void enterMessage() {
        String message = JOptionPane.showInputDialog("Enter your message:");
        if (message != null && !message.trim().isEmpty()) {
            sentMessages.add(message);
            JOptionPane.showMessageDialog(null, "Message sent!");
        } else {
            JOptionPane.showMessageDialog(null, "No message entered.");
        }
    }

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

    private static boolean isValidUsername(String username) {
        return username != null && username.length() == 5 &&
               username.contains("_") &&
               username.matches(".*\\d.*");
    }

    private static boolean isValidCellNumber(String cell) {
        return cell != null && cell.matches("\\+27\\d{10}");
    }

    private static boolean isValidPassword(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{9}|<>].*");
    }
}



    

