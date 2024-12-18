package interfaceadapter.logout;

import usecase.logout.LogoutInputBoundary;
import usecase.logout.LogoutInputData;

/**
 * The controller for the Logout Use Case.
 */
public class LogoutController {

    private final LogoutInputBoundary logoutUseCaseInteractor;

    public LogoutController(LogoutInputBoundary logoutUseCaseInteractor) {
        this.logoutUseCaseInteractor = logoutUseCaseInteractor;
    }

    /**
     * Executes the Logout Use Case.
     * @param username the username of the user logging in
     */
    public void execute(String username) {
        // 1. instantiate the `LogoutInputData`, which should contain the username.
        final LogoutInputData inputData = new LogoutInputData(username);

        // 2. tell the Interactor to execute.
        logoutUseCaseInteractor.execute(inputData);
    }
}
