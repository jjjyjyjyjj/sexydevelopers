package usecase.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String username;
    private final String password;
    private final String repeatPassword;

    public SignupInputData(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    /**
     * Returns the username of the current user.
     * @return username of the current user
     */
    String getUsername() {
        return username;
    }

    /**
     * Returns the password inputted.
     * @return password inputted
     */
    String getPassword() {
        return password;
    }

    /**
     * Returns the repeat password inputted.
     * @return repeat password
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }
}

