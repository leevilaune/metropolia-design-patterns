package dev.onesnzeroes.designpatterns.proxy.model.document;

import dev.onesnzeroes.designpatterns.proxy.model.User;

import java.time.Instant;

public class Document implements IDocument {

    private static int ID = 1;
    private int id;
    private Instant creationDate;
    private String content;

    public Document(String content){
        this.id = ID++;
        this.creationDate = Instant.now();
        this.content = content;
    }

    @Override
    public boolean isProtected(){
        return false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Instant getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getContent(User user) {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
