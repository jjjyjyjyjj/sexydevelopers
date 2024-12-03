package usecase.save_for_later;

import entity.Recipe;
import entity.User;

/**
 * The Input Data for the SaveForLater Use Case.
 */
public class SaveForLaterInputData {
    private final Recipe recipe;
    private final User user;

    public SaveForLaterInputData(User user, Recipe recipe) {
        this.user = user;
        this.recipe = recipe;
    }

    /**
     * Returns current user's username.
     * @return user's username
     */
    public String getUsername() {
        return this.user.getUsername();
    }

    /**
     * Returns recipe being saved.
     * @return recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }
}
