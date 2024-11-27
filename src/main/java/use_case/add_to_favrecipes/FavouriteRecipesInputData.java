package use_case.add_to_favrecipes;

import entity.*;

/**
 * The input data for the Add a Recipe to Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final Recipe targetRecipe;
    private final SavedRecipes favourited;
    private final User user;

    public FavouriteRecipesInputData(Recipe targetRecipe, User user) {
        this.targetRecipe = targetRecipe;
        this.favourited = user.getFavourited();
        this.user = user;
    }

    SavedRecipes getFavouriteRecipes() {
        return favourited;
    }

    User getUser() {
        return user;
    }

    Recipe getTargetRecipe() {
        return targetRecipe;
    }

}
