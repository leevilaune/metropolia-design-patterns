package dev.onesnzeroes.designpatterns.mediator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @BeforeEach
    void resetStaticId() throws Exception {
        // Reset static id for predictable tests
        java.lang.reflect.Field field = Message.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(null, 0);
    }

    @Test
    void constructor_shouldAssignFieldsCorrectly() {
        Instant now = Instant.now();

        Message m = new Message(1, 2, "hello", now);

        assertEquals(0, m.getId());
        assertEquals(1, m.getReceiverId());
        assertEquals(2, m.getSenderId());
        assertEquals("hello", m.getContent());
        assertEquals(now, m.getTs());
    }

    @Test
    void id_shouldIncrementForEachMessage() {
        Message m1 = new Message(1, 2, "a", Instant.now());
        Message m2 = new Message(1, 2, "b", Instant.now());
        Message m3 = new Message(1, 2, "c", Instant.now());

        assertEquals(0, m1.getId());
        assertEquals(1, m2.getId());
        assertEquals(2, m3.getId());
    }

    @Test
    void setters_shouldUpdateFields() {
        Message m = new Message(1, 2, "hello", Instant.now());

        m.setReceiverId(99);
        m.setSenderId(88);
        m.setContent("updated");
        Instant newTime = Instant.now();
        m.setTs(newTime);
        m.setId(42);

        assertEquals(99, m.getReceiverId());
        assertEquals(88, m.getSenderId());
        assertEquals("updated", m.getContent());
        assertEquals(newTime, m.getTs());
        assertEquals(42, m.getId());
    }

    @Test
    void toString_shouldContainImportantFields() {
        Instant ts = Instant.parse("2026-01-01T00:00:00Z");

        Message m = new Message(1, 2, "test", ts);

        String result = m.toString();

        assertTrue(result.contains("receiverId=1"));
        assertTrue(result.contains("senderId=2"));
        assertTrue(result.contains("content='test'"));
        assertTrue(result.contains("ts=2026-01-01T00:00:00Z"));
    }
}