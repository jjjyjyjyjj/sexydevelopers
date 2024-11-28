package entity;

import java.util.ArrayList;
import java.util.List;

public class SavedForLater implements SavedRecipes {
    private List<Recipe> savedRecipes;

    public void SavedRecipes() {
        this.savedRecipes = new ArrayList<>();
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