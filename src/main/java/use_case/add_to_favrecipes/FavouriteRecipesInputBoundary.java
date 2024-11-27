package use_case.add_to_favrecipes;

import entity.Recipe;

/**
 * The Add a Recipe to Favourite Recipes List Use Case.
 */
public interface FavouriteRecipesInputBoundary {

    /**
     * Execute Use Case of adding a new recipe to Favourite Recipes List.
     *
     * @param favouriteRecipesInputData the input data containing the Favourite Recipe List for this use case
     */
    void execute(FavouriteRecipesInputData favouriteRecipesInputData);
}

