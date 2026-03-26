package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class AButton extends Button{
    @Override
    public String display(){
        return "[  " + super.getText() + "   ]";
    }
}
