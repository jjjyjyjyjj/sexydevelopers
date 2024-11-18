package use_case.favourite_recipes;

import entity.Favourited;
import entity.Recipe;
import entity.User;

/**
 * The input data for the Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final Recipe tofavrecipe;
    private final Favourited favourited;
    private final String username;

    public FavouriteRecipesInputData(Recipe recipe, User user) {
        this.tofavrecipe = recipe;
        this.favourited = user.getFavourited();
        this.username = user.getUsername();
    }

    Favourited getFavouriteRecipes() {
        return favourited;
    }

    String getUsername() {
        return username;
    }

}
