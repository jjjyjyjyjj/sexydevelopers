package interface_adapter.saveforlater;

import entity.SavedForLater;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class SaveForLaterState {
    private List<SavedForLater> savedForLaterRecipes = new ArrayList<>();
    private String savedRecipesError;

    public void  setSavedRecipes(SavedForLater savedRecipe) {
        savedForLaterRecipes.add(savedRecipe);
    }
    public void setSavedRecipesError(String savedRecipesError) {
        this.savedRecipesError = savedRecipesError;
    }
}
