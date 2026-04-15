package dev.onesnzeroes.designpatterns.mediator.controller;

import dev.onesnzeroes.designpatterns.mediator.model.Message;
import dev.onesnzeroes.designpatterns.mediator.model.MessageService;
import dev.onesnzeroes.designpatterns.mediator.model.User;
import dev.onesnzeroes.designpatterns.mediator.view.ChatClient;

import java.util.ArrayList;
import java.util.List;

public class ChatController {

    private User user;
    private ChatClient chatClient;

    public ChatController(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatClient getChatClient() {
        return chatClient;
    }

    public void setChatClient(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public void sendMessage(Message message){
        MessageService.getInstance().sendMessage(message);
    }
    public void receiveMessage(User user, Message message){
        this.chatClient.receiveMessage(message);
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>(MessageService.getInstance().getUsers().values());
        users.remove(this.user);
        return users;
    }

    public String getUsername(int id){
        if(id == this.user.getUserId()){
            return "You";
        }
        return MessageService.getInstance().getUsers().get(id).getUsername();
    }
}
