package interfaceadapter.signup;

import interfaceadapter.ViewModel;

/**
 * The View Model for the Signup View.
 */
public class SignupViewModel extends ViewModel<SignupState> {

    public static final String TITLE_LABEL = "Welcome to PantryPal!";
    public static final String SIGNUP_LABEL = "Create Your Account:";
    public static final String USERNAME_LABEL = "Username:";
    public static final String PASSWORD_LABEL = "Password:";
    public static final String CONFIRM_PASSWORD_LABEL = "Confirm Password:";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";

    public static final String LOGIN_BUTTON_LABEL = "Login";

    public SignupViewModel() {
        super("sign up");
        setState(new SignupState());
    }

}
