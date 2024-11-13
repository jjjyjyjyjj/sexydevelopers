package entity;

import java.util.ArrayList;
import java.util.List;

public class RecipeBrowsedHistory {
    private List<Recipe> browsedRecipes;

    public RecipeBrowsedHistory() {
        this.browsedRecipes = new ArrayList<>();
    }

    public List<Recipe> getBrowsedRecipes() {
        return browsedRecipes;
    }

    public void addBrowsedRecipe(Recipe recipe) {
        this.browsedRecipes.add(recipe);
    }

    public void removeBrowsedRecipe(Recipe recipe) {
        this.browsedRecipes.remove(recipe);
    }
}
