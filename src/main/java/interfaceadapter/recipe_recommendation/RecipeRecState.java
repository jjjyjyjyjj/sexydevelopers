package interfaceadapter.recipe_recommendation;

import entity.Recipe;

import java.util.HashSet;
import java.util.Set;

/**
 * State for managing recipe recommendations.
 */
public class RecipeRecState {
    private Recipe currentRecipe;
    private Set<Integer> skippedRecipeIds = new HashSet<>();
    private String errorMessage;

    public RecipeRecState() {
        // Default constructor
    }

    public Recipe getCurrentRecipe() {
        return currentRecipe;
    }

    public void setCurrentRecipe(Recipe currentRecipe) {
        this.currentRecipe = currentRecipe;
    }

    public Set<Integer> getSkippedRecipeIds() {
        return skippedRecipeIds;
    }

    public void addSkippedRecipeId(int recipeId) {
        this.skippedRecipeIds.add(recipeId);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void clearErrorMessage() {
        this.errorMessage = null;
    }

    @Override
    public String toString() {
        return "RecipeRecState{" +
                "currentRecipe=" + (currentRecipe != null ? currentRecipe.getName() : "none") +
                ", skippedRecipeIds=" + skippedRecipeIds +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
