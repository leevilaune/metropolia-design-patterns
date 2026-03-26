package dev.onesnzeroes.designpatterns.abstractfactory.model.factory;

import dev.onesnzeroes.designpatterns.abstractfactory.model.*;

public class AFactory implements UIFactory{

    @Override
    public Button createButton(String text) {
        Button aButton = new AButton();
        aButton.setText(text);
        return aButton;
    }

    @Override
    public CheckBox createCheckBox(boolean checked) {
        CheckBox aCheckBox = new ACheckBox();
        aCheckBox.setChecked(checked);
        return aCheckBox;
    }

    @Override
    public TextField createTextField(String text) {
        TextField aTextField = new ATextField();
        aTextField.setText(text);
        return aTextField;
    }
}
