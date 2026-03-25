package dev.onesnzeroes.designpatterns.proxy;

import dev.onesnzeroes.designpatterns.proxy.model.AccessControlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessControlServiceTest {

    private AccessControlService acs;

    @BeforeEach
    void setup() {
        acs = AccessControlService.getInstance();
        acs.clear();
    }

    @Test
    void singletonReturnsSameInstance() {
        AccessControlService a = AccessControlService.getInstance();
        AccessControlService b = AccessControlService.getInstance();

        assertSame(a, b);
    }

    @Test
    void grantingAccessAllowsUser() {
        acs.setAccessForUser(1, "alice");

        assertTrue(acs.isAllowed(1, "alice"));
    }

    @Test
    void userWithoutAccessIsDenied() {
        acs.setAccessForUser(1, "alice");

        assertFalse(acs.isAllowed(1, "bob"));
    }

    @Test
    void multipleUsersCanAccessSameDocument() {
        acs.setAccessForUser(1, "alice");
        acs.setAccessForUser(1, "bob");

        assertTrue(acs.isAllowed(1, "alice"));
        assertTrue(acs.isAllowed(1, "bob"));
    }

    @Test
    void accessIsDocumentSpecific() {
        acs.setAccessForUser(1, "alice");

        assertTrue(acs.isAllowed(1, "alice"));
        assertFalse(acs.isAllowed(2, "alice"));
    }

    @Test
    void addingSameUserTwiceDoesNotBreak() {
        acs.setAccessForUser(1, "alice");
        acs.setAccessForUser(1, "alice");

        assertTrue(acs.isAllowed(1, "alice"));
    }
}