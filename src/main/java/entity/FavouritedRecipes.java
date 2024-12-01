package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as = FavouritedRecipes.class)
public class FavouritedRecipes implements SavedRecipes {
    private List<Recipe> favouritedRecipes;

    public FavouritedRecipes() {
        this.favouritedRecipes = new ArrayList<>();
    }

    @Override
    public List<Recipe> getRecipes() {
        return favouritedRecipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        if (!favouritedRecipes.contains(recipe)) {
            favouritedRecipes.add(recipe);
        }
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        favouritedRecipes.remove(recipe);
    }
}
