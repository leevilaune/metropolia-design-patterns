package dev.onesnzeroes.designpatterns.abstractfactory.model;

public class BCheckBox extends CheckBox{

    @Override
    public void display() {
        if(super.isChecked()){
            System.out.println("| x |");
        }else{
            System.out.println("|   |");
        }
    }
}
