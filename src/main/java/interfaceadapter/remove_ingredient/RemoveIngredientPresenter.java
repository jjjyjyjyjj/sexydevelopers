package interfaceadapter.remove_ingredient;

import interfaceadapter.LoggedInState;
import interfaceadapter.LoggedInViewModel;
import interfaceadapter.ViewManagerModel;
import usecase.remove_ingredient.RemoveIngredientOutputBoundary;
import usecase.remove_ingredient.RemoveIngredientOutputData;

/**
 * The presenter for Remove Ingredient Use Case.
 */
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
