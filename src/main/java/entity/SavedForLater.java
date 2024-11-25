package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SavedForLater implements SavedRecipes {
    private List<Recipe> savedRecipes;

    public SavedForLater() {
        this.savedRecipes = new ArrayList<>();
    }

    @Override
    public List<Recipe> getRecipes() {
        return savedRecipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.savedRecipes.add(recipe);
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        this.savedRecipes.remove(recipe);
    }
}
