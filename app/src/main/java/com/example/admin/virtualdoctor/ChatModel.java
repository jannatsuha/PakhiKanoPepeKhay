package com.example.admin.virtualdoctor;

public class ChatModel {

    private String chatMe;
    private String chatBot;
    private String keyId;

    public ChatModel(String chatMe, String chatBot) {
        this.chatMe = chatMe;
        this.chatBot = chatBot;
    }

    public ChatModel(String chatMe, String chatBot, String keyId) {
        this.chatMe = chatMe;
        this.chatBot = chatBot;
        this.keyId = keyId;
    }

    public ChatModel() {
    }

    public String getKeyId() {
        return keyId;
    }

    public String getChatMe() {
        return chatMe;
    }

    public void setChatMe(String chatMe) {
        this.chatMe = chatMe;
    }

    public String getChatBot() {
        return chatBot;
    }

    public void setChatBot(String chatBot) {
        this.chatBot = chatBot;
    }
}

