package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class BTextField extends TextField{
    @Override
    public void display() {
        System.out.println("|  " + super.getText() + "   |");
    }
}
