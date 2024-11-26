package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.FavouritedRecipes;
import entity.PantryPalUser;

/**
 * The input data for the Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final CommonRecipe targetRecipe;
    private final FavouritedRecipes favourited;
    private final PantryPalUser user;

    public FavouriteRecipesInputData(CommonRecipe targetRecipe, PantryPalUser user) {
        this.targetRecipe = targetRecipe;
        this.favourited = user.getFavourited();
        this.user = user;
    }

    FavouritedRecipes getFavouriteRecipes() {
        return favourited;
    }

    PantryPalUser getUser() {
        return user;
    }

    CommonRecipe getTargetRecipe() {
        return targetRecipe;
    }

}
