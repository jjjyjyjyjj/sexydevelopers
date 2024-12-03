package entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * SavedforLater class, stores user's saved recipes.
 */
@JsonDeserialize(as = SavedForLater.class)
public class SavedForLater implements SavedRecipes {
    private List<Recipe> savedRecipes;
    private String name;

    /**
     * Initializes the variables for SavedForLater class.
     */
    public void setSavedRecipes() {
        this.savedRecipes = new ArrayList<>();
        this.name = "saved for later";
    }

    @Override
    public List<Recipe> getRecipes() {
        return savedRecipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        if (!savedRecipes.contains(recipe)) {
            savedRecipes.add(recipe);
        }
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        savedRecipes.remove(recipe);
    }
}
