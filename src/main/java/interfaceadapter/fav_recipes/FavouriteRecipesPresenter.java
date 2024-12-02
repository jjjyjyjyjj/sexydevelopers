package interfaceadapter.fav_recipes;

import usecase.add_to_fav_recipes.FavouriteRecipesOutputBoundary;
import usecase.add_to_fav_recipes.FavouriteRecipesOutputData;
import usecase.remove_from_fav_recipes.RemoveFavRecipeOutputBoundary;
import usecase.remove_from_fav_recipes.RemoveFavRecipeOutputData;

/**
 * The Presenter for the Favourite Recipes Use Case.
 */
public class FavouriteRecipesPresenter implements FavouriteRecipesOutputBoundary, RemoveFavRecipeOutputBoundary {
    private final FavouriteRecipesViewModel favouriteRecipesViewModel;

    public FavouriteRecipesPresenter(FavouriteRecipesViewModel favouriteRecipesViewModel) {
        this.favouriteRecipesViewModel = favouriteRecipesViewModel;
    }

    /**
     * Prepares the success view for Favourite Recipes Use Cases.
     *
     * @param outputData the output data
     */
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

    /**
     * Prepares the fail view for the Remove a Recipe from Favourite Recipes List Use Case.
     *
     * @param error the error message
     */
    @Override
    public void prepareFailView(String error) {
        final FavouriteRecipesState favouriteRecipesState = favouriteRecipesViewModel.getState();
        favouriteRecipesState.setremoveRecipeError(error);
        favouriteRecipesViewModel.firePropertyChanged();
    }
}
