/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;



public class Login {

    



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a username: ");
        String Username = sc.next();
        System.out.println("Please enter a password: ");
        String Password = sc.next();
        System.out.println("Please your cellphone number: ");
        String CellphoneNumber = sc.next();
        boolean isUsernameValid = CheckUsername(Username);
        boolean isPasswordValid = CheckPasswordComplexity(Password);
        boolean isCellphoneNumberValid = CheckCellphoneNumberComplexity(CellphoneNumber);
    }

    public static boolean CheckCellphoneNumberComplexity(String cellphoneNumber) {
        if (cellphoneNumber.contains("+27") && cellphoneNumber.length() == 12) {
            System.out.println("Your number is correct.");
        } else {
            System.out.println("Your number is incorrect.");
        }

        return true;
    }

    public static boolean CheckUsername(String Username) {
        if (Username.contains("_") && Username.length() > 5) {
            System.out.println("Username has been succefully captured. ");
        } else {
            System.out.println("Username does not contain an underscore or is not 5 characters.");
        }

        return true;
    }

    public static boolean CheckPasswordComplexity(String Password) {
        if (Password.length() > 8) {
            System.out.println("Password captured successfully. ");
        } else {
            System.out.println("Password is incorrectly formatted.");
        }

        boolean ContainsUppercase = false;
        boolean Containslowercase = false;
        boolean ContainsNumber = false;
        boolean ContainsSpecialCharacter = false;
        int i = 0;
        if (i < Password.length()) {
            char ch = Password.charAt(i);
            if (Character.isUpperCase(ch)) {
                ContainsUppercase = true;
            }

            if (Character.isLowerCase(ch)) {
                Containslowercase = true;
            }

            if (Character.isDigit(ch)) {
                ContainsNumber = true;
            }

            if (!Character.isLetter(ch) && !Character.isDigit(ch) && !Character.isWhitespace(ch)) {
                ContainsSpecialCharacter = true;
            }

            return true;
        } else {
            return true;
        }
    }
}
