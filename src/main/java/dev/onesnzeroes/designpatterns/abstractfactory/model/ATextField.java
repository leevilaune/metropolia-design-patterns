package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class ATextField extends TextField{
    @Override
    public void display() {
        System.out.println("[  " + super.getText() + "   ]");
    }
}
