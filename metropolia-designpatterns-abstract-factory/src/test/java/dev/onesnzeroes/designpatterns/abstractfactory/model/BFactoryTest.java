package dev.onesnzeroes.designpatterns.abstractfactory.model;

import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.BFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.UIFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BFactoryTest {

    @Test
    void createsButtonWithBStyle() {
        UIFactory factory = new BFactory();

        Button button = factory.createButton("BButton");

        String output = button.display();

        assertTrue(output.contains("BButton"));
        assertTrue(output.contains("|"));
    }

    @Test
    void createsTextFieldWithBStyle() {
        UIFactory factory = new BFactory();

        TextField tf = factory.createTextField("Text");

        String output = tf.display();

        assertTrue(output.contains("Text"));
        assertTrue(output.contains("|"));
    }

    @Test
    void setTextUpdatesCorrectly() {
        UIFactory factory = new BFactory();

        TextField tf = factory.createTextField("Old");

        tf.setText("Updated");

        assertTrue(tf.display().contains("Updated"));
    }
}