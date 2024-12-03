package interface_adapter.remove_ingredient;

import interface_adapter.LoggedInState;
import interface_adapter.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import use_case.remove_ingredient.RemoveIngredientOutputBoundary;
import use_case.remove_ingredient.RemoveIngredientOutputData;

public class RemoveIngredientPresenter implements RemoveIngredientOutputBoundary {

    private final RemoveIngredientViewModel removeIngredientViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public RemoveIngredientPresenter(RemoveIngredientViewModel removeIngredientViewModel,
                                     LoggedInViewModel loggedInViewModel,
                                     ViewManagerModel viewManagerModel) {
        this.removeIngredientViewModel = removeIngredientViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RemoveIngredientOutputData response) {
        // On success, switch to the logged in view.

        final LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setFridge(response.getFridge());
        loggedInState.getUser().setFridge(loggedInState.getFridge());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setState(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final RemoveIngredientState removeIngredientState = removeIngredientViewModel.getState();
        removeIngredientState.setRemoveError(error);
        removeIngredientViewModel.firePropertyChanged();

    }
}
