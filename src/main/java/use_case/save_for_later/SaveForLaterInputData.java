package use_case.save_for_later;


import entity.*;

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

    public String getUsername() {
        return this.user.getUsername();
    }

    public Recipe getRecipe() {
        return recipe;
    }
}