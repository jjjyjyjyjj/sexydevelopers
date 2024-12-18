package interfaceadapter.signup;

import usecase.signup.SignupInputBoundary;
import usecase.signup.SignupInputData;

/**
 * The controller for the Signup Use Case.
 */
public class SignupController {

    private final SignupInputBoundary userSignupUseCaseInteractor;

    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the Signup Use Case.
     * @param username the username to sign up
     * @param password the password
     * @param repeatPassword the password repeated
     */
    public void execute(String username, String password, String repeatPassword) {
        final SignupInputData signupInputData = new SignupInputData(
                username, password, repeatPassword);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToLoginView() {
        userSignupUseCaseInteractor.switchToLoginView();
    }
}
