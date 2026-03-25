package dev.onesnzeroes.designpatterns.proxy;

import dev.onesnzeroes.designpatterns.proxy.model.*;
import dev.onesnzeroes.designpatterns.proxy.model.document.IDocument;
import dev.onesnzeroes.designpatterns.proxy.model.exception.AccessDeniedException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        System.out.println("=== Adding Documents ===");
        // Add unprotected document
        int publicDocId = library.addUnprotectedDocument("Public Document Content");
        System.out.println("Added unprotected document with ID: " + publicDocId);

        // Add protected document
        int secretDocId = library.addProtectedDocument("Secret Document Content", alice);
        System.out.println("Added protected document with ID: " + secretDocId);

        System.out.println("\n=== Accessing Unprotected Document ===");
        IDocument publicDoc = library.getDocument(publicDocId);
        System.out.println("Alice reads public doc: " + publicDoc.getContent(alice));
        System.out.println("Bob reads public doc: " + publicDoc.getContent(bob));
        System.out.println("Charlie reads public doc: " + publicDoc.getContent(charlie));

        System.out.println("\n=== Accessing Protected Document ===");
        IDocument secretDoc = library.getDocument(secretDocId);

        // Alice should succeed
        System.out.println("Alice reads secret doc: " + secretDoc.getContent(alice));

        // Bob should fail
        System.out.println("Bob reads secret doc: " + secretDoc.getContent(bob));

        // Charlie should fail
        System.out.println("Charlie reads secret doc: " + secretDoc.getContent(charlie));

        System.out.println("\n=== Granting Access to Bob ===");
        acs.setAccessForUser(secretDocId, bob.getUsername());

        System.out.println("Bob reads secret doc after access granted: " + secretDoc.getContent(bob));

        System.out.println("\n=== Metadata Access Without Authorization ===");
        System.out.println("Creation date of secret doc: " + secretDoc.getCreationDate());

        System.out.println("\n=== Testing Nonexistent Document ===");
        IDocument missingDoc = library.getDocument(999);
        if (missingDoc == null) {
            System.out.println("Document 999 does not exist.");
        }

        System.out.println("\n=== Listing All Access in AccessControlService ===");
        System.out.println("Alice allowed? " + acs.isAllowed(secretDocId, "alice"));
        System.out.println("Bob allowed? " + acs.isAllowed(secretDocId, "bob"));
        System.out.println("Charlie allowed? " + acs.isAllowed(secretDocId, "charlie"));
    }
}