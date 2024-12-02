package interfaceadapter.favRecipes;

import entity.Recipe;
import entity.User;
import usecase.addToFavRecipes.FavouriteRecipesInputBoundary;
import usecase.addToFavRecipes.FavouriteRecipesInputData;

/**
 * Controller for Favourite Recipes Use Cases.
 */
public class FavouriteRecipesController {
    private final FavouriteRecipesInputBoundary favRecipesUseCaseInteractor;

    public FavouriteRecipesController(FavouriteRecipesInputBoundary favRecipesUseCaseInteractor) {
        this.favRecipesUseCaseInteractor = favRecipesUseCaseInteractor;
    }

    /**
     * Executes the Favourite Recipe Use Case.
     *
     * @param recipe the new recipe that is favourited
     * @param username the username whose favourite recipes list is being changed
     */
    public void execute(Recipe recipe, User username) {
        final FavouriteRecipesInputData favouriteRecipesInputData = new FavouriteRecipesInputData(recipe, username);

        favRecipesUseCaseInteractor.execute(favouriteRecipesInputData);
    }
}
