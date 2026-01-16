package dev.onesnzeroes.designpatterns.abstractfactory;

import dev.onesnzeroes.designpatterns.abstractfactory.model.Button;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.AFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.BFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.UIFactory;

public class Main {

    public static void main(String[] args) {
        UIFactory factory = new AFactory();
        Button button = factory.createButton("AButton");
        button.display();
        button.setText("AButtonEdit");
        button.display();
        factory.createCheckBox(true).display();
        factory.createCheckBox(false).display();

        System.out.println();

        factory = new BFactory();
        button = factory.createButton("BButton");
        button.display();
        button.setText("BButtonEdit");
        button.display();
        factory.createCheckBox(true).display();
        factory.createCheckBox(false).display();
    }
}
