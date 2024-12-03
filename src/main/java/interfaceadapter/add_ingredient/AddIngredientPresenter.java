package interfaceadapter.add_ingredient;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.fridge.FridgeViewModel;
import usecase.add_ingredient.AddIngredientOutputBoundary;
import usecase.add_ingredient.AddIngredientOutputData;

public class AddIngredientPresenter implements AddIngredientOutputBoundary {

    private final AddIngredientViewModel addIngredientViewModel;
    private final FridgeViewModel fridgeViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddIngredientPresenter(AddIngredientViewModel addIngredientViewModel,
                                  FridgeViewModel fridgeViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.addIngredientViewModel = addIngredientViewModel;
        this.fridgeViewModel = fridgeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AddIngredientOutputData response) {
        // On success, switch to the fridge view.

        final LoggedInState loggedInState = fridgeViewModel.getState();
        loggedInState.setFridge(response.getFridge());
        loggedInState.getUser().setFridge(loggedInState.getFridge());
        this.fridgeViewModel.setState(loggedInState);
        this.fridgeViewModel.firePropertyChanged();

        this.viewManagerModel.setState(fridgeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoggedInState addIngredientState = addIngredientViewModel.getState();
        addIngredientState.setAddError(error);
        addIngredientViewModel.firePropertyChanged();
    }

    @Override
    public void switchToFridgeView() {
        viewManagerModel.setState(fridgeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
