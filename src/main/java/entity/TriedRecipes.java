package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as = TriedRecipes.class)
public class TriedRecipes implements SavedRecipes {
    private final List<Recipe> triedRecipes;
    private final String name;

    public TriedRecipes() {
        this.triedRecipes = new ArrayList<>();
        this.name = "tried recipes";
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
