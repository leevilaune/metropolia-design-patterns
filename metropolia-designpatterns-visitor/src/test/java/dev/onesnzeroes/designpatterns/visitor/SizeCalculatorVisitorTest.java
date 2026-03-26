package dev.onesnzeroes.designpatterns.visitor;

import dev.onesnzeroes.designpatterns.visitor.model.element.*;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SizeCalculatorVisitor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SizeCalculatorVisitorTest {

    @Test
    void calculatesFlatStructure() {
        Directory root = dir(
                file("a.txt", 10),
                file("b.txt", 20)
        );

        assertEquals(30, size(root));
    }

    @Test
    void calculatesNestedStructure() {
        Directory root = dir(
                file("a.txt", 10),
                dir(file("b.txt", 20))
        );

        assertEquals(30, size(root));
    }

    @Test
    void emptyDirectoryReturnsZero() {
        Directory root = dir();

        assertEquals(0, size(root));
    }

    @Test
    void deeplyNestedStructure() {
        Directory root = dir(
                dir(
                        dir(
                                file("deep.txt", 50)
                        )
                )
        );

        assertEquals(50, size(root));
    }

    @Test
    void zeroSizeFilesHandled() {
        Directory root = dir(
                file("empty.txt", 0),
                file("real.txt", 25)
        );

        assertEquals(25, size(root));
    }

    private int size(Directory root) {
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        root.accept(visitor);
        return visitor.getTotalSize();
    }

    private File file(String name, int size) {
        return new File(name, size);
    }

    private Directory dir(IFileSystemElement... elements) {
        return new Directory("dir",List.of(elements));
    }
}