package interfaceadapter.login;

/**
 * The state for the Login View Model.
 */
public class LoginState {
    private String username = "";
    private String loginError;
    private String password = "";

    /**
     * Returns username of current user.
     * @return username of user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns error message for this use case.
     * @return error message
     */
    public String getLoginError() {
        return loginError;
    }

    /**
     * Returns current user's password.
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set current user's username.
     * @param username user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set the error message for this use case.
     * @param usernameError error message
     */
    public void setLoginError(String usernameError) {
        this.loginError = usernameError;
    }

    /**
     * Set the current user's password.
     * @param password user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
