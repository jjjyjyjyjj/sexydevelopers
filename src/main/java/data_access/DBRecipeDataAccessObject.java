package data_access;

import entity.Recipe;
import entity.User;
import use_case.favourite_recipes.FavouriteRecipesDataAccessInterface;

public class DBRecipeDataAccessObject implements FavouriteRecipesDataAccessInterface {
    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param recipe the recipe that is to be added to favourite recipes
     */
    @Override
    public void FavouriteRecipes(Recipe recipe) {

    }

    /**
     * Checks if given recipe is in user's favpurited recipe list.
     *
     * @param recipe the recipe to look for
     * @param user   the user whose list we're searching through
     * @return true if recipe is in user's list; false otherwise
     */
    @Override
    public boolean existsByRecipe(Recipe recipe, User user) {
        return false;
    }
}
