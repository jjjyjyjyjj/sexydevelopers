package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.Recipe;

/**
 * The Favourite CommonRecipe Use Case.
 */
public interface FavouriteRecipesInputBoundary {

    /**
     * Execute Use Case of Favouriting a new recipe.
     * @param favouriteRecipesInputData the input data containing the Favourite Recipe List for this use case
     */
    void execute(FavouriteRecipesInputData favouriteRecipesInputData);


    /**
     * Execute Use Case of Removing a Recipe from the Favourite Recipes List.
     * @param favouriteRecipesInputData the input data containing the Favourite Recipe List for this use case
     * @param recipeToRemove the recipe intended to be removed from the list
     */
    void remove(FavouriteRecipesInputData favouriteRecipesInputData, Recipe recipeToRemove);
}

