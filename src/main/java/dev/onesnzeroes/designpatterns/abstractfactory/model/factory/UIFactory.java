package dev.onesnzeroes.designpatterns.abstractfactory.model.factory;

import dev.onesnzeroes.designpatterns.abstractfactory.model.Button;
import dev.onesnzeroes.designpatterns.abstractfactory.model.CheckBox;
import dev.onesnzeroes.designpatterns.abstractfactory.model.TextField;

public interface UIFactory {

    Button createButton(String text);
    CheckBox createCheckBox(boolean checked);
    TextField createTextField(String text);
}
