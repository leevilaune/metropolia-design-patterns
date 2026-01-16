package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class BButton extends Button{
    @Override
    public void display(){
        System.out.println("|  " + super.getText() + "   |");
    }
}
