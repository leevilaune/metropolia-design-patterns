package dev.onesnzeroes.designpatterns.abstractfactory.model;

public abstract class TextField {

    private String text;

    public TextField(){
        this.text = "Text field...";
    }

    public abstract void display();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
