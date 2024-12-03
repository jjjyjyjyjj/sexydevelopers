package usecase.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {

    private final String password;
    private final String username;

    public ChangePasswordInputData(String password, String username) {
        this.password = password;
        this.username = username;
    }

    /**
     * Returns the password of the current user.
     * @return password of the current user.
     */
    String getPassword() {
        return password;
    }

    /**
     * Returns the username of the current user.
     * @return username of the current user.
     */
    String getUsername() {
        return username;
    }

}
