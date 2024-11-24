package entity;

import java.util.ArrayList;
import java.util.List;

public class SavedForLaterRecipes implements SavedRecipes {
    private List<CommonRecipe> savedRecipes;

    public SavedForLaterRecipes() {
        this.savedRecipes = new ArrayList<>();
    }

    @Override
    public List<CommonRecipe> getRecipes() {
        return savedRecipes;
    }

    @Override
    public void addRecipe(CommonRecipe recipe) {
        savedRecipes.add(recipe);
    }

    @Override
    public void removeRecipe(CommonRecipe recipe) {
        savedRecipes.remove(recipe);
    }
}
