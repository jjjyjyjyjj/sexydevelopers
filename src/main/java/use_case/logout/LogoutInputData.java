package use_case.logout;

/**
 * The Input Data for the Logout Use Case.
 */
public class LogoutInputData {
    private final String currentUser;

    /**
     * Initializes the current user.
     * @param username username of the current user
     */
    public LogoutInputData(String username) {
        this.currentUser = username;
    }

    /**
     * Returns the username of the current user.
     * @return username of the current user
     */
    public String getCurrentUser() {
        return currentUser;
    }
}
