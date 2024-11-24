package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing recipes saved for later.
 */
public class SavedForLater {
    private final List<Recipe> recipes;

    public SavedForLater() {
        this.recipes = new ArrayList<>();
    }

    /**
     * Adds a recipe to the SavedForLater list if it's not already present.
     *
     * @param recipe The recipe to add.
     * @throws IllegalArgumentException if the recipe is null.
     */
    public void addRecipe(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("Recipe cannot be null.");
        }
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
        }
    }

    /**
     * Retrieves all recipes currently saved for later.
     *
     * @return A list of saved recipes.
     */
    public List<Recipe> getRecipes() {
        return new ArrayList<>(recipes);
    }

    /**
     * Checks if a recipe is already saved.
     *
     * @param recipe The recipe to check.
     * @return true if the recipe is in the list, false otherwise.
     */
    public boolean isRecipeSaved(Recipe recipe) {
        return recipes.contains(recipe);
    }

    /**
     * Retrieves the number of saved recipes.
     *
     * @return The size of the saved recipes list.
     */
    public int getSavedRecipesCount() {
        return recipes.size();
    }
}