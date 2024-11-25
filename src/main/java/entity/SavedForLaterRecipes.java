package entity;

import java.util.ArrayList;
import java.util.List;

public class SavedForLaterRecipes implements SavedRecipes {
    private List<Recipe> savedRecipes;

    public SavedForLaterRecipes() {
        this.savedRecipes = new ArrayList<>();
    }

    @Override
    public List<Recipe> getRecipes() {
        return savedRecipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        savedRecipes.add(recipe);
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        savedRecipes.remove(recipe);
    }
}
