package dev.onesnzeroes.designpatterns.prototype.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationTest {

    @Test
    void constructor_shouldInitializeCorrectly() {
        Recommendation rec = new Recommendation("Beginners");

        assertEquals("Beginners", rec.getTargetAudience());
        assertNotNull(rec.getRecommendedBooks());
        assertTrue(rec.getRecommendedBooks().isEmpty());
    }

    @Test
    void setTargetAudience_shouldUpdateValue() {
        Recommendation rec = new Recommendation("Old");

        rec.setTargetAudience("New");

        assertEquals("New", rec.getTargetAudience());
    }

    @Test
    void addBook_shouldAddBookToList() {
        Recommendation rec = new Recommendation("Readers");

        Book book = new Book("Dune", "Frank Herbert");
        rec.addBook(book);

        assertEquals(1, rec.getRecommendedBooks().size());
        assertEquals("Dune", rec.getRecommendedBooks().get(0).getTitle());
    }

    @Test
    void removeBook_shouldRemoveCorrectBook() {
        Recommendation rec = new Recommendation("Readers");

        rec.addBook(new Book("Book1", "Author1"));
        rec.addBook(new Book("Book2", "Author2"));

        rec.removeBook(rec.getRecommendedBooks().get(0));

        assertEquals(1, rec.getRecommendedBooks().size());
        assertEquals("Book2", rec.getRecommendedBooks().get(0).getTitle());
    }

    @Test
    void removeBook_invalidIndex_shouldDoNothing() {
        Recommendation rec = new Recommendation("Readers");

        rec.addBook(new Book("Book1", "Author1"));

        rec.removeBook(new Book("Book5","Author5")); // invalid

        assertEquals(1, rec.getRecommendedBooks().size());
    }

    @Test
    void clone_shouldCreateDeepCopy() throws CloneNotSupportedException {
        Recommendation original = new Recommendation("Students");

        original.addBook(new Book("Book1", "Author1"));
        original.addBook(new Book("Book2", "Author2"));

        Recommendation clone = original.clone();

        // Different object
        assertNotSame(original, clone);

        // Different list reference
        assertNotSame(original.getRecommendedBooks(), clone.getRecommendedBooks());

        // Same size
        assertEquals(original.getRecommendedBooks().size(), clone.getRecommendedBooks().size());

        for (int i = 0; i < original.getRecommendedBooks().size(); i++) {
            Book originalBook = original.getRecommendedBooks().get(i);
            Book clonedBook = clone.getRecommendedBooks().get(i);

            assertNotSame(originalBook, clonedBook);
            assertEquals(originalBook.getTitle(), clonedBook.getTitle());
            assertEquals(originalBook.getAuthor(), clonedBook.getAuthor());
        }
    }

    @Test
    void clone_modifyingClone_shouldNotAffectOriginal() throws CloneNotSupportedException {
        Recommendation original = new Recommendation("Developers");
        original.addBook(new Book("Clean Code", "Robert C. Martin"));

        Recommendation clone = original.clone();

        clone.getRecommendedBooks().get(0).setTitle("Modified");

        assertEquals("Clean Code", original.getRecommendedBooks().get(0).getTitle());
        assertEquals("Modified", clone.getRecommendedBooks().get(0).getTitle());
    }

    @Test
    void clone_addingBookToClone_shouldNotAffectOriginal() throws CloneNotSupportedException {
        Recommendation original = new Recommendation("Readers");
        original.addBook(new Book("Book1", "Author1"));

        Recommendation clone = original.clone();
        clone.addBook(new Book("Book2", "Author2"));

        assertEquals(1, original.getRecommendedBooks().size());
        assertEquals(2, clone.getRecommendedBooks().size());
    }
}