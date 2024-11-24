package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.FavouritedRecipes;
import entity.PantryPalUser;

/**
 * The input data for the Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final CommonRecipe tofavrecipe;
    private final FavouritedRecipes favourited;
    private final String username;

    public FavouriteRecipesInputData(CommonRecipe recipe, PantryPalUser user) {
        this.tofavrecipe = recipe;
        this.favourited = user.getFavourited();
        this.username = user.getUsername();
    }

    FavouritedRecipes getFavouriteRecipes() {
        return favourited;
    }

    String getUsername() {
        return username;
    }

}
