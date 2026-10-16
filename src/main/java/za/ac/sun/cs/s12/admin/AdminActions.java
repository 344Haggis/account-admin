package za.ac.sun.cs.s12.admin;

import za.ac.sun.cs.s12.status.Status;

/** Per-status decisions for the account administration console. */
public final class AdminActions {

    private AdminActions() {}

    /**
     * The console's suggested action for an account in the given status.
     * Fails to compile against status-core 2.0.0: the LEGACY constant it
     * switches on was removed.
     */
    @SuppressWarnings("deprecation")
    public static String suggestedAction(Status status) {
        switch (status) {
            case ACTIVE:
                return "none";
            case SUSPENDED:
                return "review suspension";
            case LEGACY:
                return "archive and notify owner";
            default:
                return "escalate";
        }
    }

    /** Whether the nightly cleanup job may archive an account in this status. */
    @SuppressWarnings("deprecation")
    public static boolean isArchivable(Status status) {
        return status == Status.LEGACY;
    }
}
