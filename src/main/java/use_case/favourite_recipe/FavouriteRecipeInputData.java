package use_case.favourite_recipe;

import entity.Favourited;
import entity.Recipe;

import java.util.ArrayList;

/**
 * The input data for the Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final Recipe recipe;
    private final Favourited favourited;

    public FavouriteRecipesInputData(Recipe recipe, Favourited favourited) {
        this.recipe = recipe;
        this.favourited = favourited;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

}

}
