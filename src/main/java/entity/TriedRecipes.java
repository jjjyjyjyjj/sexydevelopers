package entity;

import java.util.ArrayList;
import java.util.List;

public class TriedRecipes implements SavedRecipes {
    private List<CommonRecipe> triedRecipes;

    public TriedRecipes() {
        this.triedRecipes = new ArrayList<>();
    }

    @Override
    public List<CommonRecipe> getRecipes() {
        return triedRecipes;
    }

    @Override
    public void addRecipe(CommonRecipe recipe) {
        this.triedRecipes.add(recipe);
    }

    @Override
    public void removeRecipe(CommonRecipe recipe) {
        this.triedRecipes.remove(recipe);
    }
}
