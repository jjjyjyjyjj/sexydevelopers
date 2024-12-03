package interfaceadapter.signup;

/**
 * The state for the Signup View Model.
 */
public class SignupState {
    private String username = "";
    private String usernameError;
    private String password = "";
    private String passwordError;
    private String repeatPassword = "";
    private String repeatPasswordError;

    /**
     * Return current user's username.
     * @return user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Return error message for this use case.
     * @return error message
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Return the current user's password.
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return error message for first password entered.
     * @return error message
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Returns repeat password.
     * @return repeat password
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Returns error message for an error in repeat password.
     * @return error message
     */
    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    /**
     * Sets current user's username.
     * @param username user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set error message for current user's username.
     * @param usernameError error message
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets current user's password.
     * @param password user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets error message when password is being set.
     * @param passwordError error message
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Sets repeat password.
     * @param repeatPassword repeat password
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    /**
     * Sets the error message for repeat password.
     * @param repeatPasswordError error message
     */
    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    @Override
    public String toString() {
        return "SignupState{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", repeatPassword='" + repeatPassword + '\''
                + '}';
    }
}
