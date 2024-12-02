package interface_adapter.fav_recipes;

import entity.Recipe;
import entity.User;
import usecase.add_to_fav_recipes.FavouriteRecipesInputBoundary;
import usecase.add_to_fav_recipes.FavouriteRecipesInputData;

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
