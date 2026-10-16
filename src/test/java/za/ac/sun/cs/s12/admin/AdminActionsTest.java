package za.ac.sun.cs.s12.admin;

import org.junit.jupiter.api.Test;
import za.ac.sun.cs.s12.status.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdminActionsTest {

    @Test
    void activeAccountsNeedNoAction() {
        assertEquals("none", AdminActions.suggestedAction(Status.ACTIVE));
    }

    @Test
    void suspendedAccountsGetReviewed() {
        assertEquals("review suspension", AdminActions.suggestedAction(Status.SUSPENDED));
    }

    @Test
    @SuppressWarnings("deprecation")
    void legacyAccountsAreArchived() {
        assertEquals("archive and notify owner", AdminActions.suggestedAction(Status.LEGACY));
        assertTrue(AdminActions.isArchivable(Status.LEGACY));
        assertFalse(AdminActions.isArchivable(Status.ACTIVE));
    }
}
