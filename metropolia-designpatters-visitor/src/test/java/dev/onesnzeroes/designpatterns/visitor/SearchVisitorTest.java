package dev.onesnzeroes.designpatterns.visitor;

import dev.onesnzeroes.designpatterns.visitor.model.element.*;
import dev.onesnzeroes.designpatterns.visitor.model.visitor.SearchVisitor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchVisitorTest {

    @Test
    void findsTxtFiles() {
        Directory root = dir(
                file("a.txt", 5),
                file("b.jpg", 10),
                file("c.txt", 15)
        );

        List<File> result = search(root, ".txt");

        assertEquals(2, result.size());
    }

    @Test
    void noMatchesReturnsEmptyList() {
        Directory root = dir(
                file("a.jpg", 5),
                file("b.png", 10)
        );

        assertTrue(search(root, ".txt").isEmpty());
    }

    @Test
    void emptyDirectoryReturnsEmptyList() {
        Directory root = dir();

        assertTrue(search(root, ".txt").isEmpty());
    }

    @Test
    void findsFilesInNestedDirectories() {
        Directory root = dir(dir(file("deep.txt", 20)));

        List<File> result = search(root, ".txt");

        assertEquals(1, result.size());
        assertEquals("deep.txt", result.get(0).getFileName());
    }

    @Test
    void multipleLevelsMultipleMatches() {
        Directory root = dir(file("a.txt", 5),
                dir(file("b.txt", 10)),
                dir(file("c.txt", 15))
        );

        assertEquals(3, search(root, ".txt").size());
    }

    @Test
    void caseSensitivityCheck() {
        Directory root = dir(
                file("FILE.TXT", 10),
                file("file.txt", 10)
        );

        List<File> result = search(root, ".txt");

        // adjust if your implementation is case-insensitive
        assertEquals(1, result.size());
    }

    private List<File> search(Directory root, String query) {
        SearchVisitor visitor = new SearchVisitor(query);
        root.accept(visitor);
        return visitor.getFoundFiles();
    }

    private File file(String name, int size) {
        return new File(name, size);
    }

    private Directory dir(IFileSystemElement... elements) {
        return new Directory("dir",List.of(elements));
    }
}