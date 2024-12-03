package interfaceadapter.saveforlater;

import java.util.ArrayList;
import java.util.List;

import entity.SavedForLater;

/**
 * The state for Save for Later Use Case.
 */
public class SaveForLaterState {
    private List<SavedForLater> savedForLaterRecipes = new ArrayList<>();
    private String savedRecipesError;

    /**
     * Adds a recipe to the list of saved recipes.
     * @param savedRecipe recipe added
     */
    public void setSavedRecipes(SavedForLater savedRecipe) {
        savedForLaterRecipes.add(savedRecipe);
    }

    /**
     * Sets the error message for this use case.
     * @param savedRecipesError error message
     */
    public void setSavedRecipesError(String savedRecipesError) {
        this.savedRecipesError = savedRecipesError;
    }
}
