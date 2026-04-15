package dev.onesnzeroes.designpatterns.prototype.model;

import dev.onesnzeroes.designpatterns.prototype.model.Recommendation;
import dev.onesnzeroes.designpatterns.prototype.model.RecommendationRegistry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationRegistryTest {

    @Test
    void addEntry_andGetByTargetAudience_shouldReturnClone() throws CloneNotSupportedException {
        RecommendationRegistry registry = new RecommendationRegistry();

        Recommendation rec = new Recommendation("Students");
        rec.addBook(new Book("Book1", "Author1"));

        registry.addEntry(rec);

        Recommendation fetched = registry.getByTargetAudience("Students");

        // Should not be same instance
        assertNotSame(rec, fetched);

        // Same content
        assertEquals(rec.getTargetAudience(), fetched.getTargetAudience());
        assertEquals(rec.getRecommendedBooks().size(), fetched.getRecommendedBooks().size());
    }

    @Test
    void getByTargetAudience_modifyingReturnedObject_shouldNotAffectStoredPrototype() throws CloneNotSupportedException {
        RecommendationRegistry registry = new RecommendationRegistry();

        Recommendation rec = new Recommendation("Developers");
        rec.addBook(new Book("Clean Code", "Robert C. Martin"));

        registry.addEntry(rec);

        Recommendation clone = registry.getByTargetAudience("Developers");

        // Modify clone
        clone.getRecommendedBooks().get(0).setTitle("Modified");

        // Fetch again
        Recommendation fresh = registry.getByTargetAudience("Developers");

        // Original should remain unchanged
        assertEquals("Clean Code", fresh.getRecommendedBooks().get(0).getTitle());
    }

    @Test
    void getByTargetAudience_nonExistingKey_shouldThrowException() {
        RecommendationRegistry registry = new RecommendationRegistry();

        assertThrows(IllegalArgumentException.class, () -> {
            registry.getByTargetAudience("NonExisting");
        });
    }

    @Test
    void multipleClones_shouldBeIndependent() throws CloneNotSupportedException {
        RecommendationRegistry registry = new RecommendationRegistry();

        Recommendation rec = new Recommendation("Readers");
        rec.addBook(new Book("Book1", "Author1"));

        registry.addEntry(rec);

        Recommendation clone1 = registry.getByTargetAudience("Readers");
        Recommendation clone2 = registry.getByTargetAudience("Readers");

        clone1.addBook(new Book("Book2", "Author2"));

        assertEquals(1, clone2.getRecommendedBooks().size());
        assertEquals(2, clone1.getRecommendedBooks().size());
    }
}