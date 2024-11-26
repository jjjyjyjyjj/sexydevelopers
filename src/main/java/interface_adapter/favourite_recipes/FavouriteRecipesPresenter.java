package interface_adapter.favourite_recipes;

import use_case.favourite_recipes.FavouriteRecipesOutputBoundary;
import use_case.favourite_recipes.FavouriteRecipesOutputData;

/**
 * The Presenter for the Favourite Recipe Use Case.
 */
public class FavouriteRecipesPresenter implements FavouriteRecipesOutputBoundary {
    private final FavouriteRecipesViewModel favouriteRecipesViewModel;

    public FavouriteRecipesPresenter(FavouriteRecipesViewModel favouriteRecipesViewModel) {
        this.favouriteRecipesViewModel = favouriteRecipesViewModel;
    }

    @Override
    public void prepareSuccessView(FavouriteRecipesOutputData outputData) {
        loggedinViewModel.firePropertyChanged("favourite recipes");

    }

    @Override
    public void prepareFailView(String error) {
    }
}

//esponsibility: take the Output Data and turn it
//into raw strings and numbers to be displayed.
//Update the View Model with this information.

