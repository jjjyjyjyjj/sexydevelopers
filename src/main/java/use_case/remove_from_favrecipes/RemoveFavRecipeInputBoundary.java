package use_case.remove_from_favrecipes;

import entity.Recipe;
import use_case.remove_from_favrecipes.RemoveFavRecipeInputData;

/**
 * The Remove a Recipe from Favourite Recipes List Use Case.
 */

public interface RemoveFavRecipeInputBoundary {

    /**
     * Execute Use Case of Removing a Recipe from the Favourite Recipes List.
     * @param removeFavRecipeInputData the input data containing the Favourite Recipe List for this use case
     * @param recipeToRemove the recipe intended to be removed from the list
     */
    void execute(RemoveFavRecipeInputData removeFavRecipeInputData, Recipe recipeToRemove);
}
