package dev.onesnzeroes.designpatterns.mediator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    void resetStaticId() {
        // reset static counter so tests are predictable
        User.setId(0);
    }

    @Test
    void constructor_shouldAssignUserIdAndUsername() {
        User u = new User("Alice");

        assertEquals(0, u.getUserId());
        assertEquals("Alice", u.getUsername());
    }

    @Test
    void userId_shouldIncrementForEachUser() {
        User u1 = new User("A");
        User u2 = new User("B");
        User u3 = new User("C");

        assertEquals(0, u1.getUserId());
        assertEquals(1, u2.getUserId());
        assertEquals(2, u3.getUserId());
    }

    @Test
    void setUsername_shouldUpdateName() {
        User u = new User("Old");

        u.setUsername("New");

        assertEquals("New", u.getUsername());
    }

    @Test
    void setUserId_shouldOverrideId() {
        User u = new User("Test");

        u.setUserId(99);

        assertEquals(99, u.getUserId());
    }

    @Test
    void staticId_shouldIncrementGlobally() {
        new User("A");
        new User("B");

        assertEquals(2, User.getId());
    }

    @Test
    void toString_shouldReturnUsername() {
        User u = new User("Alice");

        assertEquals("Alice", u.toString());
    }
}