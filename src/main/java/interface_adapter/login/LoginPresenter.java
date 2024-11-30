package interface_adapter.login;

import interface_adapter.LoggedInState;
import interface_adapter.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.recipeRecommendation.RecipeRecState;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final RecipeRecViewModel recipeRecViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          RecipeRecViewModel recipeRecViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recipeRecViewModel = recipeRecViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the home view.

        final LoggedInState loggedInState = recipeRecViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.recipeRecViewModel.setState(loggedInState);
        this.recipeRecViewModel.firePropertyChanged();

        this.viewManagerModel.setState(recipeRecViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(error);
        loginViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSwitchToSignupView() {
        viewManagerModel.setState("Sign Up");
        viewManagerModel.firePropertyChanged();
    }
}
