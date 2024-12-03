package use_case.remove_from_fav_recipes;

/**
 * The Remove a Recipe from Favourite Recipes List Use Case.
 */

public interface RemoveFavRecipeInputBoundary {

    /**
     * Execute Use Case of Removing a Recipe from the Favourite Recipes List.
     * @param removeFavRecipeInputData the input data containing the Favourite Recipe List for this use case
     */
    void execute(RemoveFavRecipeInputData removeFavRecipeInputData);
}
