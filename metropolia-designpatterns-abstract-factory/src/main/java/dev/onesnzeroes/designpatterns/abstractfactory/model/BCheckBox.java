package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class BCheckBox extends CheckBox{

    @Override
    public String display() {
        if(super.isChecked()){
            return  "| x |";
        }else{
            return  "|   |";
        }
    }
}
