package dev.onesnzeroes.designpatterns.mediator.model;

import dev.onesnzeroes.designpatterns.mediator.controller.ChatController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        // reset MessageService singleton
        Field instance = MessageService.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);

        // reset User static id
        User.setId(0);
    }

    @Test
    void getInstance_shouldReturnSameObject() {
        MessageService s1 = MessageService.getInstance();
        MessageService s2 = MessageService.getInstance();

        assertSame(s1, s2);
    }

    @Test
    void createController_shouldCreateUserAndController() {
        MessageService service = MessageService.getInstance();

        ChatController controller = service.createController("Alice");

        assertNotNull(controller);
        assertEquals(1, service.getUsers().size());
        assertEquals(1, service.getControllers().size());
    }

    @Test
    void createController_shouldAssignIncrementingUserIds() {
        MessageService service = MessageService.getInstance();

        service.createController("A");
        service.createController("B");

        assertEquals(0, service.getUsers().get(0).getUserId());
        assertEquals(1, service.getUsers().get(1).getUserId());
    }

    @Test
    void addUser_shouldStoreUser() {
        MessageService service = MessageService.getInstance();

        User u = new User("Test");

        service.addUser(u);

        assertEquals(1, service.getUsers().size());
        assertTrue(service.getUsers().containsKey(u.getUserId()));
    }
}