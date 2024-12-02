package usecase.removeFromFavRecipes;

import entity.Recipe;
import entity.User;

/**
 * The interface of the DAO for the Remove a Recipe from Favourite Recipes List Use Case.
 */
public interface RemoveFavRecipeDataAccessInterface {
    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param user the user whose favourite recipes list is to be updated
     * @param recipe the recipe that is to be removed from favourite recipes
     */
    void updateFavouriteRecipes(User user, Recipe recipe);

    void updateSavedRecipes(User user, Recipe recipe);
}
