package usecase.login;

/**
 * The Input Data for the Login Use Case.
 */
public class LoginInputData {

    private final String username;
    private final String password;

    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username of the current user.
     * @return username of current user.
     */
    String getUsername() {
        return username;
    }

    /**
     * Returns the password of the current user.
     * @return password of the current user.
     */
    String getPassword() {
        return password;
    }

}
