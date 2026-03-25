package dev.onesnzeroes.designpatterns.proxy;

import dev.onesnzeroes.designpatterns.proxy.model.*;
import dev.onesnzeroes.designpatterns.proxy.model.document.IDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setup() {
        library = new Library();
        AccessControlService.getInstance().clear();
    }

    // =========================
    // UNPROTECTED DOCUMENTS
    // =========================

    @Test
    void unprotectedDocumentAccessibleToAllUsers() {
        User alice = new User("alice");
        User bob = new User("bob");

        int id = library.addUnprotectedDocument("Public");

        IDocument doc = library.getDocument(id);

        assertNotNull(doc);
        assertEquals("Public", doc.getContent(alice));
        assertEquals("Public", doc.getContent(bob));
    }

    // =========================
    // PROTECTED DOCUMENTS
    // =========================

    @Test
    void protectedDocumentAccessibleWithAuthorizedUser() {
        User alice = new User("alice");

        int id = library.addProtectedDocument("Secret", alice);

        IDocument doc = library.getDocument(id);

        assertNotNull(doc);
        assertEquals("Secret", doc.getContent(alice));
    }

    @Test
    void protectedDocumentDeniedForUnauthorizedUser() {
        User alice = new User("alice");
        User bob = new User("bob");

        int id = library.addProtectedDocument("Secret", alice);

        IDocument doc = library.getDocument(id);
        boolean accessDeniedForBob = doc.getContent(bob).contentEquals("Document is protected and user bob has no access");
        assertTrue(accessDeniedForBob);
    }

    // =========================
    // LIBRARY BEHAVIOR
    // =========================

    @Test
    void gettingNonexistentDocumentReturnsNull() {
        IDocument doc = library.getDocument(999);

        assertNull(doc);
    }

    @Test
    void multipleDocumentsStoredCorrectly() {
        User alice = new User("alice");

        int id1 = library.addUnprotectedDocument("Doc1");
        int id2 = library.addProtectedDocument("Doc2", alice);

        assertNotNull(library.getDocument(id1));
        assertNotNull(library.getDocument(id2));
    }

    @Test
    void protectedDocumentRequiresCorrectUser() {
        User alice = new User("alice");
        User bob = new User("bob");

        int id = library.addProtectedDocument("Secret", alice);

        IDocument document = library.getDocument(id);
        boolean allow = !document.getContent(alice).contentEquals("Document is protected and user alice has no access");
        boolean deny = document.getContent(bob).contentEquals("Document is protected and user bob has no access");
        assertTrue(allow);
        assertTrue(deny);
    }

    @Test
    void unprotectedDocumentIsNotProtected() {
        IDocument doc = library.getDocument(
                library.addUnprotectedDocument("Public")
        );

        assertFalse(doc.isProtected());
    }

    @Test
    void differentProtectedDocumentsHaveDifferentAccess() {
        User alice = new User("alice");
        User bob = new User("bob");

        int doc1 = library.addProtectedDocument("Secret1", alice);
        int doc2 = library.addProtectedDocument("Secret2", bob);

        IDocument d1 = library.getDocument(doc1);
        IDocument d2 = library.getDocument(doc2);

        assertEquals("Secret1", d1.getContent(alice));
        assertEquals("Secret2", d2.getContent(bob));

        assertTrue(d1.getContent(bob).contains("no access"));
        assertTrue(d2.getContent(alice).contains("no access"));
    }
}