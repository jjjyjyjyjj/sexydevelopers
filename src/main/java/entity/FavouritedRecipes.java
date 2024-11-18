package entity;

import java.util.ArrayList;
import java.util.List;

public class FavouritedRecipes implements SavedRecipes {
    private List<CommonRecipe> favouritedRecipes;

    public FavouritedRecipes() {
        this.favouritedRecipes = new ArrayList<>();
    }

    @Override
    public List<CommonRecipe> getRecipes() {
        return favouritedRecipes;
    }

    @Override
    public void addRecipe(CommonRecipe recipe) {
        if (!favouritedRecipes.contains(recipe)) {
            favouritedRecipes.add(recipe);
        }
    }

    @Override
    public void removeRecipe(CommonRecipe recipe) {
        favouritedRecipes.remove(recipe);
    }
}
