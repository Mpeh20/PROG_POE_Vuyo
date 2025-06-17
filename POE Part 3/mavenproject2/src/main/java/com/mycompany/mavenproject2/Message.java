/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author RC_Student_lab
 */
// Message.java

public class Message {
    private String sender;
    private String recipient;
    private String content;
    private String messageHash;
    private String messageID;

    public Message() {
        // Default constructor for JSON parsing
    }

    public Message(String sender, String recipient, String content, String messageHash, String messageID) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.messageHash = messageHash;
        this.messageID = messageID;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getMessageID() {
        return messageID;
    }

    // Setters
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessageHash(String messageHash) {
        this.messageHash = messageHash;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Message{" +
               "sender='" + sender + '\'' +
               ", recipient='" + recipient + '\'' +
               ", content='" + content + '\'' +
               ", messageHash='" + messageHash + '\'' +
               ", messageID='" + messageID + '\'' +
               '}';
    }
}

