package dev.onesnzeroes.designpatterns.mediator.model;

public class User {

    private static int id = 0;
    private int userId;
    private String username;

    public User(String username){
        this.userId = id;
        this.username = username;
        id++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
