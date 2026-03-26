package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class ATextField extends TextField {
    @Override
    public String display() {
        return "[  " + super.getText() + "   ]";
    }
}
