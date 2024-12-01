package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as = SavedForLater.class)
public class SavedForLater implements SavedRecipes {
    private List<Recipe> savedRecipes;
    private String name;

    public void SavedRecipes() {
        this.savedRecipes = new ArrayList<>();
        this.name = "saved for later";
    }

    @Override
    public List<Recipe> getRecipes() {
        return savedRecipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        if (!savedRecipes.contains(recipe)) {
            savedRecipes.add(recipe);
        }
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        savedRecipes.remove(recipe);
    }
}