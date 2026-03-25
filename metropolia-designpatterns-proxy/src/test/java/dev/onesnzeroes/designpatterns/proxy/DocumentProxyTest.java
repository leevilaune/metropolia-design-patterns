package dev.onesnzeroes.designpatterns.proxy;

import dev.onesnzeroes.designpatterns.proxy.model.AccessControlService;
import dev.onesnzeroes.designpatterns.proxy.model.User;
import dev.onesnzeroes.designpatterns.proxy.model.document.Document;
import dev.onesnzeroes.designpatterns.proxy.model.document.DocumentProxy;
import dev.onesnzeroes.designpatterns.proxy.model.document.IDocument;
import dev.onesnzeroes.designpatterns.proxy.model.exception.AccessDeniedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class DocumentProxyTest {

    private IDocument realDocument;
    private DocumentProxy proxy;
    private AccessControlService acs;
    private User alice;
    private User bob;

    @BeforeEach
    void setup() {
        acs = AccessControlService.getInstance();
        acs.clear();
        alice = new User("alice");
        bob = new User("bob");

        realDocument = new Document("Secret Content");
        proxy = new DocumentProxy(realDocument);

        acs.setAccessForUser(proxy.getId(), alice.getUsername());
    }

    @Test
    void isProtectedAlwaysTrue() {
        assertTrue(proxy.isProtected());
    }

    @Test
    void getIdMatchesRealDocument() {
        assertEquals(realDocument.getId(), proxy.getId());
    }

    @Test
    void getContentAllowedUserReturnsContent() {
        String content = proxy.getContent(alice);
        assertEquals("Secret Content", content);
    }

    @Test
    void getContentDeniedUserReturnsExceptionMessage() {
        String message = proxy.getContent(bob);
        assertTrue(message.contains("Document is protected"));
        assertTrue(message.contains("bob"));
    }

    @Test
    void getCreationDateMatchesRealDocument() {
        Instant creationDate = proxy.getCreationDate();
        assertEquals(realDocument.getCreationDate(), creationDate);
    }

    @Test
    void setCreationDateUpdatesRealDocument() {
        Instant now = Instant.now();
        proxy.setCreationDate(now);
        assertEquals(now, realDocument.getCreationDate());
    }

    @Test
    void setContentDoesNotThrow() {
        assertDoesNotThrow(() -> proxy.setContent("New Content"));
    }
}