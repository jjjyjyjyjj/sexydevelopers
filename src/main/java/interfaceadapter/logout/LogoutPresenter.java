package interfaceadapter.logout;

import interfaceadapter.LoggedInViewModel;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.login.LoginViewModel;
import usecase.logout.LogoutOutputBoundary;
import usecase.logout.LogoutOutputData;

/**
 * The Presenter for the Logout Use Case.
 */
public class LogoutPresenter implements LogoutOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel,
                           LoggedInViewModel loggedInViewModel,
                           LoginViewModel loginViewModel) {

        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LogoutOutputData response) {
        // We need to switch to the login view, which should have
        // an empty username and password.

        // We also need to set the username in the LoggedInState to
        // the empty string.

        // 1. get the LoggedInState out of the appropriate View Model,
        var loggedInState = loggedInViewModel.getState();
        // 2. set the username in the state to the empty string
        loggedInState.setUsername("");
        // 3. set the state in the LoggedInViewModel to the updated state
        loggedInViewModel.setState(loggedInState);
        // 4. firePropertyChanged so that the View that is listening is updated.
        loggedInViewModel.firePropertyChanged();

        // 5. get the LoginState out of the appropriate View Model,
        var loginState = loginViewModel.getState();
        // 6. set the username and password in the state to the empty string
        loginState.setUsername("");
        // 7. set the state in the LoginViewModel to the updated state
        loginViewModel.setState(loginState);
        // 8. firePropertyChanged so that the View that is listening is updated.
        loginViewModel.firePropertyChanged();

        // This code tells the View Manager to switch to the LoginView.
        this.viewManagerModel.setState(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // No need to add code here. We'll assume that logout can't fail.
        // Thought question: is this a reasonable assumption?
    }
}
