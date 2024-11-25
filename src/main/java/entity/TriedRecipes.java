package entity;

import java.util.ArrayList;
import java.util.List;

public class TriedRecipes implements SavedRecipes {
    private List<Recipe> triedRecipes;

    public TriedRecipes() {
        this.triedRecipes = new ArrayList<>();
    }

    @Override
    public List<Recipe> getRecipes() {
        return triedRecipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.triedRecipes.add(recipe);
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        this.triedRecipes.remove(recipe);
    }
}
