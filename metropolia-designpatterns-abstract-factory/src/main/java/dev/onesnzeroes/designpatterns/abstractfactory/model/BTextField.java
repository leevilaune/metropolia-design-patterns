package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class BTextField extends TextField {
    @Override
    public String display() {
        return "|  " + super.getText() + "   |";
    }
}
