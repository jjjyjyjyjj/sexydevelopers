package use_case.saveforlater;

import entity.PantryPalUser;
import entity.User;

/**
 * Data access interface for Save For Later use case.
 */
public interface SaveForLaterUserDataAccessInterface {
    boolean saveRecipeForUser(String userId, String recipeId);

    User getUserById(String userId);

    void updateUserSavedRecipes(User user);
}