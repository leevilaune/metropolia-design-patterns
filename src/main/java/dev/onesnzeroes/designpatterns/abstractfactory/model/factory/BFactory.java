package dev.onesnzeroes.designpatterns.abstractfactory.model.factory;

import dev.onesnzeroes.designpatterns.abstractfactory.model.*;

public class BFactory implements UIFactory{

    @Override
    public Button createButton(String text) {
        Button bButton = new BButton();
        bButton.setText(text);
        return bButton;
    }

    @Override
    public CheckBox createCheckBox(boolean checked) {
        CheckBox bCheckBox = new BCheckBox();
        bCheckBox.setChecked(checked);
        return bCheckBox;
    }

    @Override
    public TextField createTextField(String text) {
        TextField bTextField = new BTextField();
        bTextField.setText(text);
        return bTextField;
    }
}
