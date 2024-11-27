package use_case.saveforlater;

import entity.User;
import entity.Recipe;


/**
 * DAO for the Save For Later Use Case.
 */
public interface SaveForLaterUserDataAccessInterface {
    void save(User user);

    /**
     * Returns the user with the given username.
     * @param username the username to look up
     * @return the user with the given username
     */
    User get(String username);

    /**
     * Updates the system to update this user's saved recipes.
     * @param recipe the recipe that is to be added to favourite recipes
     */
    void SavedRecipes(User user, Recipe recipe);

    /**
     * Checks if given recipe is in user's saved recipe list.
     * @param user the user whose list we're searching through
     * @param recipe the recipe to look for
     * @return true if recipe is in user's list; false otherwise
     */
    boolean existsByRecipe(Recipe recipe, User user);

    /**
     * Checks if given recipe in user's saved recipe list has already been tried.
     * @param user the user whose list we're searching through
     * @param recipe the recipe to look for
     * @return true if recipe is in user's list and has already been tried; false otherwise.
     */
    boolean triedRecipe(Recipe recipe, User user);

    User getUserById(String userId);

    void updateUserSavedRecipes(User user);
}