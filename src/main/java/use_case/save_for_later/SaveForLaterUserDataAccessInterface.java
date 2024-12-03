package use_case.save_for_later;

import entity.Recipe;
import entity.User;

/**
 * Data access interface for Save For Later use case.
 */
public interface SaveForLaterUserDataAccessInterface {
    boolean saveRecipeForUser(String userId, String recipeId);

    User getUserById(String userId);

    void updateUserSavedRecipes(User user);

    boolean existsByRecipe(Recipe toSavedRecipe, User user);
}
