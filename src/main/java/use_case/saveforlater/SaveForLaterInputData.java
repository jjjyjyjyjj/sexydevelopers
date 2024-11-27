package use_case.saveforlater;


import entity.Recipe;
import entity.User;

/**
 * The Input Data for the SaveForLater Use Case.
 */
public class SaveForLaterInputData {
    private final String userId;
    private final Recipe recipe;

    public SaveForLaterInputData(String userId, Recipe recipe) {
        this.userId = userId;
        this.recipe = recipe;
    }

    public String getUserId() {
        return userId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public int getRecipeId() {
        return recipe.getID();
    }
}
