package usecase.change_password;

/**
 * Output Data for the Change Password Use Case.
 */
public class ChangePasswordOutputData {

    private final String username;

    private final boolean useCaseFailed;

    public ChangePasswordOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Return the username of the current user.
     * @return username of the current user
     */
    public String getUsername() {
        return username;
    }

    public final boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
