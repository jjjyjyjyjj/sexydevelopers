package usecase.save_for_later;

import entity.Recipe;
import entity.User;

/**
 * Data access interface for Save For Later use case.
 */
public interface SaveForLaterUserDataAccessInterface {
    boolean saveRecipeForUser(String userId, String recipeId);

    /**
     * Gets the user from the given id.
     * @param userId user's id
     * @return user
     */
    User getUserById(String userId);

    /**
     * Updates the user's list of saved recipes.
     * @param user user
     */
    void updateUserSavedRecipes(User user);

    /**
     * Return true if .
     * @param toSavedRecipe recipe to be saved
     * @param user current user
     * @return true if
     */
    boolean existsByRecipe(Recipe toSavedRecipe, User user);
}
