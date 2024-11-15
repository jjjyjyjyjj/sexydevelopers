package entity;

import java.util.ArrayList;
import java.util.List;

public class Favourited {
    private List<Recipe> favouritedRecipes;

    public Favourited() {
        this.favouritedRecipes = new ArrayList<>();
    }

    public List<Recipe> getFavouritedRecipes() {
        return favouritedRecipes;
    }

    public void addFavouritedRecipes(Recipe recipe) {
        if (!favouritedRecipes.contains(recipe)) {
            favouritedRecipes.add(recipe);
        }
    }

    public void removeFavouritedRecipes(Recipe recipe) {
        favouritedRecipes.remove(recipe);
    }
}
