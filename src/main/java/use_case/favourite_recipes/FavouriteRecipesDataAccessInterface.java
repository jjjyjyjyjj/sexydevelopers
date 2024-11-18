package use_case.favourite_recipes;

import entity.Recipe;
import entity.User;

/**
 * The interface of the DAO for the Favourite Recipe Use Case.
 */
public interface FavouriteRecipesDataAccessInterface {

    /**
     * Updates the system to update this user's favourite recipes.
     * @param recipe the recipe that is to be added to favourite recipes
     */
    void FavouriteRecipes(User user, Recipe recipe);

    /**
     * Checks if given recipe is in user's favpurited recipe list.
     * @param user the user whose list we're searching through
     * @param recipe the recipe to look for
     * @return true if recipe is in user's list; false otherwise
     */
    boolean existsByRecipe(Recipe recipe, User user);
}
