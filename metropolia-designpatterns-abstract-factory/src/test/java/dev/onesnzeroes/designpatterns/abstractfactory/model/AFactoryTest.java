package dev.onesnzeroes.designpatterns.abstractfactory.model;

import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.AFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.UIFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AFactoryTest {

    @Test
    void createsButtonWithCorrectStyle() {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("AButton");

        String output = button.display();

        assertTrue(output.contains("AButton"));
        assertTrue(output.contains("["));
        assertTrue(output.contains("]"));
    }

    @Test
    void createsTextFieldWithCorrectStyle() {
        UIFactory factory = new AFactory();

        TextField tf = factory.createTextField("Hello");

        String output = tf.display();

        assertTrue(output.contains("Hello"));
        assertTrue(output.contains("["));
    }

    @Test
    void createsCheckboxUnchecked() {
        UIFactory factory = new AFactory();

        CheckBox cb = factory.createCheckBox(true);

        String output = cb.display();

        assertTrue(output.contains("["));
        assertTrue(output.contains("]"));
    }

    @Test
    void setTextUpdatesDisplay() {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("Old");

        button.setText("New");

        assertTrue(button.display().contains("New"));
        assertFalse(button.display().contains("Old"));
    }
}