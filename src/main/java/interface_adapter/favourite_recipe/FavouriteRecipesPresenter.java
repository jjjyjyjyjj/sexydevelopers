package interface_adapter.favourite_recipe;

import use_case.add_to_favrecipes.FavouriteRecipesOutputBoundary;
import use_case.add_to_favrecipes.FavouriteRecipesOutputData;
import use_case.remove_from_favrecipes.RemoveFavRecipeOutputBoundary;
import use_case.remove_from_favrecipes.RemoveFavRecipeOutputData;

/**
 * The Presenter for the Favourite Recipes Use Case.
 */
public class FavouriteRecipesPresenter implements FavouriteRecipesOutputBoundary, RemoveFavRecipeOutputBoundary{
    private final FavouriteRecipesViewModel favouriteRecipesViewModel;

    public FavouriteRecipesPresenter(FavouriteRecipesViewModel favouriteRecipesViewModel) {
        this.favouriteRecipesViewModel = favouriteRecipesViewModel;
    }

    @Override
    public void prepareSuccessView(FavouriteRecipesOutputData outputData) {
        favouriteRecipesViewModel.firePropertyChanged("favourite recipes");

    }

    /**
     * Prepares the success view for the Remove a Recipe from Favourite Recipes List Use Case.
     *
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(RemoveFavRecipeOutputData outputData) {
        favouriteRecipesViewModel.firePropertyChanged("favourite recipes");
    }

    @Override
    public void prepareFailView(String error) {
    }
}
