package use_case.favourite_recipe;

import entity.Favourited;

/**
 * The input data for the Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final Favourited favourited;

    public FavouriteRecipesInputData(Favourited favourited) {
        this.favourited = favourited;
    }

    Favourited getFavouriteRecipes() {
        return favourited;
    }
}
