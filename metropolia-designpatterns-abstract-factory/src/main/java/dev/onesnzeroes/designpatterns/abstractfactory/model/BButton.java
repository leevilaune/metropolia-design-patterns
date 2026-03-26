package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class BButton extends Button{
    @Override
    public String display(){
        return "|  " + super.getText() + "   |";
    }
}
