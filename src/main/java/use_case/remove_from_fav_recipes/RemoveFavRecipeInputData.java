package use_case.remove_from_fav_recipes;

import entity.FavouritedRecipes;
import entity.Recipe;
import entity.SavedRecipes;
import entity.User;
/**
 * The input data for the Remove a Recipe from Favourite Recipes List Use Case.
 */

public class RemoveFavRecipeInputData {
    private final Recipe targetRecipe;
    private final SavedRecipes favourited;
    private final SavedRecipes savedforlater;
    private final User user;

    public RemoveFavRecipeInputData(Recipe targetRecipe, User user) {
        this.targetRecipe = targetRecipe;
//        this.favourited = user.getFavourited();
        this.favourited = new FavouritedRecipes();
        this.savedforlater = user.getSavedForLater();
        this.user = user;
    }

    SavedRecipes getFavouriteRecipes() {
        return favourited;
    }

    SavedRecipes getSavedForLater() { return savedforlater; }

    User getUser() {
        return user;
    }

    Recipe getTargetRecipe() {
        return targetRecipe;
    }

}
