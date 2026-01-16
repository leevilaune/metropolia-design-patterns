package dev.onesnzeroes.designpatterns.abstractfactory.model;

public abstract class CheckBox {

    private boolean checked;

    public CheckBox(){
        this.checked = false;
    }

    public abstract void display();

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
