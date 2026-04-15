package dev.onesnzeroes.designpatterns.mediator.model;

import java.time.Instant;

public class Message {

    private static int id = 0;
    private int messageId;
    private int receiverId;
    private int senderId;
    private String content;
    private Instant ts;

    public Message(int receiverId, int senderId, String content, Instant ts) {
        this.messageId = id;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.content = content;
        this.ts = ts;
        id++;
    }

    public int getId() {
        return messageId;
    }

    public void setId(int id) {
        this.messageId = id;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getTs() {
        return ts;
    }

    public void setTs(Instant ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", receiverId=" + receiverId +
                ", senderId=" + senderId +
                ", content='" + content + '\'' +
                ", ts=" + ts +
                '}';
    }
}
