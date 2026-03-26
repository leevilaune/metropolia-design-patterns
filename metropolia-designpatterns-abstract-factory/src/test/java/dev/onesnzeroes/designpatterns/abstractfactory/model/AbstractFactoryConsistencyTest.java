package dev.onesnzeroes.designpatterns.abstractfactory.model;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.AFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.BFactory;
import dev.onesnzeroes.designpatterns.abstractfactory.model.factory.UIFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryConsistencyTest {

    @Test
    void factoryAProducesOnlyAStyle() {
        UIFactory factory = new AFactory();

        String button = factory.createButton("X").display();
        String tf = factory.createTextField("Y").display();

        assertTrue(button.contains("["));
        assertTrue(tf.contains("["));
    }

    @Test
    void factoryBProducesOnlyBStyle() {
        UIFactory factory = new BFactory();

        String button = factory.createButton("X").display();
        String tf = factory.createTextField("Y").display();

        assertTrue(button.contains("|"));
        assertTrue(tf.contains("|"));
    }
}