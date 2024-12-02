package interfaceadapter.favRecipes;

import entity.Recipe;
import entity.User;
import usecase.removeFromFavRecipes.RemoveFavRecipeInputBoundary;
import usecase.removeFromFavRecipes.RemoveFavRecipeInputData;

/**
 * The Controller for Removing a Recipe from Favourite Recipes Use Case.
 */

public class RemoveFavRecipeController {
    private final RemoveFavRecipeInputBoundary removeFavRecipeUseCaseInteractor;

    public RemoveFavRecipeController(RemoveFavRecipeInputBoundary removeFavRecipeUseCaseInteractor) {
        this.removeFavRecipeUseCaseInteractor = removeFavRecipeUseCaseInteractor;
    }

    /**
     * Executes the Remove a Recipe from Favourite Recipes List Use Case.
     * @param recipe the recipe that is to be removed
     * @param username the username whose favourite recipes list is being changed
     */
    public void execute(Recipe recipe, User username) {
        final RemoveFavRecipeInputData removeFavRecipeInputData = new RemoveFavRecipeInputData(recipe, username);

        removeFavRecipeUseCaseInteractor.execute(removeFavRecipeInputData);
    }
}
