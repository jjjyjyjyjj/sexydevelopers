package usecase.add_to_fav_recipes;

import entity.Recipe;
import entity.SavedRecipes;
import entity.User;

/**
 * The input data for the Add a Recipe to Favourite Recipes Use Case.
 */

public class FavouriteRecipesInputData {
    private final Recipe targetRecipe;
    private final SavedRecipes favourited;
    private final User user;

    /**
    * Instantiating the instance variables for the FavouriteRecipesInputData class.
    *
    * @param targetRecipe the recipe intended to be added to favourites
    *
    * @param user the user whose favourite recipes list is being updated
    */
    public FavouriteRecipesInputData(Recipe targetRecipe, User user) {
        this.targetRecipe = targetRecipe;
        this.favourited = user.getFavourited();
        this.user = user;
    }

    /**
     *  Return the favourite recipes list of the current user.
     * @return favourite recipes list
     */
    public SavedRecipes getFavouriteRecipes() {
        return favourited;
    }

    /**
     * Return the current user.
     * @return the current user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the recipe that is being added to favourite recipes.
     * @return the recipe being added
     */
    public Recipe getTargetRecipe() {
        return targetRecipe;
    }

}
