package dev.onesnzeroes.designpatterns.abstractfactory.model;

import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.AFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.BFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.UIFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCaseTest {

    @Test
    void emptyTextHandled() {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("");

        assertNotNull(button.display());
    }

    @Test
    void nullTextHandledGracefully() {
        UIFactory factory = new AFactory();

        Button button = factory.createButton(null);

        assertNotNull(button.display());
    }

    @Test
    void longTextDoesNotBreakDisplay() {
        UIFactory factory = new BFactory();

        String longText = "ThisIsAVeryLongTextThatShouldStillRender";

        TextField tf = factory.createTextField(longText);

        assertTrue(tf.display().contains(longText));
    }

    @Test
    void multipleSetTextCallsWork() {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("A");

        button.setText("B");
        button.setText("C");

        assertTrue(button.display().contains("C"));
    }
}
