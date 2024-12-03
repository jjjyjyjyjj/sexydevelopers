package interfaceadapter.add_ingredient;

import interfaceadapter.LoggedInState;
import interfaceadapter.LoggedInViewModel;
import interfaceadapter.ViewManagerModel;
import use_case.add_ingredient.AddIngredientOutputBoundary;
import use_case.add_ingredient.AddIngredientOutputData;

public class AddIngredientPresenter implements AddIngredientOutputBoundary {

    private final AddIngredientViewModel addIngredientViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddIngredientPresenter(AddIngredientViewModel addIngredientViewModel,
                                  LoggedInViewModel loggedInViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.addIngredientViewModel = addIngredientViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AddIngredientOutputData response) {
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
        final AddIngredientState addIngredientState = addIngredientViewModel.getState();
        addIngredientState.setAddError(error);
        addIngredientViewModel.firePropertyChanged();
    }
}
