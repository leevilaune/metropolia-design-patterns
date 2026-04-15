package dev.onesnzeroes.designpatterns.prototype.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void defaultConstructor_shouldCreateEmptyBook() {
        Book book = new Book();

        assertNull(book.getTitle());
        assertNull(book.getAuthor());
    }

    @Test
    void parameterizedConstructor_shouldSetFieldsCorrectly() {
        Book book = new Book("1984", "George Orwell");

        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
    }

    @Test
    void settersAndGetters_shouldWorkCorrectly() {
        Book book = new Book();

        book.setTitle("Dune");
        book.setAuthor("Frank Herbert");

        assertEquals("Dune", book.getTitle());
        assertEquals("Frank Herbert", book.getAuthor());
    }

    @Test
    void clone_shouldCreateDifferentObjectWithSameValues() throws CloneNotSupportedException {
        Book original = new Book("The Hobbit", "J.R.R. Tolkien");

        Book clone = original.clone();

        // Different instance
        assertNotSame(original, clone);

        // Same values
        assertEquals(original.getTitle(), clone.getTitle());
        assertEquals(original.getAuthor(), clone.getAuthor());
    }

    @Test
    void clone_modifyingClone_shouldNotAffectOriginal() throws CloneNotSupportedException {
        Book original = new Book("Original", "Author");

        Book clone = original.clone();
        clone.setTitle("Modified");
        clone.setAuthor("Different");

        assertEquals("Original", original.getTitle());
        assertEquals("Author", original.getAuthor());

        assertEquals("Modified", clone.getTitle());
        assertEquals("Different", clone.getAuthor());
    }

    @Test
    void toString_shouldContainTitleAndAuthor() {
        Book book = new Book("Clean Code", "Robert C. Martin");

        String result = book.toString();

        assertTrue(result.contains("Clean Code"));
        assertTrue(result.contains("Robert C. Martin"));
    }
}