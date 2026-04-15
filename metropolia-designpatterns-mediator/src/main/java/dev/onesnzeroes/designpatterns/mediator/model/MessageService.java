package dev.onesnzeroes.designpatterns.mediator.model;

import dev.onesnzeroes.designpatterns.mediator.controller.ChatController;

import java.util.HashMap;
import java.util.Map;

public class MessageService {

    private static MessageService instance;

    private Map<Integer, User> users;
    private Map<Integer, ChatController> controllers;
    private Map<Integer, Message> messages;

    private MessageService(){
        this.users = new HashMap<>();
        this.messages = new HashMap<>();
        this.controllers = new HashMap<>();
    }

    public static MessageService getInstance(){
        if(instance == null){
            instance = new MessageService();
        }
        return instance;
    }

    public ChatController createController(String username){
        User user = new User(username);
        this.users.put(user.getUserId(), user);

        ChatController controller = new ChatController(user);
        this.controllers.put(user.getUserId(), controller);
        return controller;
    }

    public void addUser(User u){
        this.users.put(u.getUserId(),u);
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public Map<Integer, ChatController> getControllers() {
        return controllers;
    }

    public void setControllers(Map<Integer, ChatController> controllers) {
        this.controllers = controllers;
    }

    public Map<Integer, Message> getMessages() {
        return messages;
    }

    public void setMessages(Map<Integer, Message> messages) {
        this.messages = messages;
    }

    public void sendMessage(Message message){
        System.out.println(message);
        this.receiveMessage(message);
    }

    public void receiveMessage(Message message){
        this.controllers.get(message.getReceiverId()).receiveMessage(users.get(message.getSenderId()),message);
    }
}
