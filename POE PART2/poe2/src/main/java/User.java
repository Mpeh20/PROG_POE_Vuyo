/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */

public class User {
    
    private String fullName;
    private String username;
    private String password;
    private String phone;

    // Constructor
    public User(String fullName, String username, String password, String phone) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    // Setters (optional)
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


