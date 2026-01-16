package dev.onesnzeroes.designpatterns.abstractfactory.model;

public abstract class Button {

    private String text;

    public Button(){
        this.text = "BUTTON";
    }

    public abstract void display();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
