package interfaceadapter.recipeRecommendation;

import java.util.HashSet;
import java.util.Set;

import entity.Recipe;

/**
 * State for Recipe Recommender Use Case, manages recipe recommendations.
 */
public class RecipeRecState {
    private Recipe currentRecipe;
    private Set<Integer> skippedRecipeIds = new HashSet<>();
    private String errorMessage;

    public RecipeRecState() {
        // Default constructor
    }

    /**
     * Returns current recommended recipe.
     * @return recommended recipe
     */
    public Recipe getCurrentRecipe() {
        return currentRecipe;
    }

    /**
     * Sets the recommended recipe.
     * @param currentRecipe recommended recipe
     */
    public void setCurrentRecipe(Recipe currentRecipe) {
        this.currentRecipe = currentRecipe;
    }

    /**
     * Returns a set of skipped recipes ids.
     * @return set of skipped recipes ids
     */
    public Set<Integer> getSkippedRecipeIds() {
        return skippedRecipeIds;
    }

    /**
     * Adds an ids of a skipped recipe.
     * @param recipeId ids of a skipped recipe
     */
    public void addSkippedRecipeId(int recipeId) {
        this.skippedRecipeIds.add(recipeId);
    }

    /**
     * Returns the error message.
     * @return error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message.
     * @param errorMessage error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Clears the error message.
     */
    public void clearErrorMessage() {
        this.errorMessage = null;
    }

    @Override
    public String toString() {
        return "RecipeRecState{"
                + "currentRecipe=" + (currentRecipe != null ? currentRecipe.getName() : "none")
                + ", skippedRecipeIds=" + skippedRecipeIds
                + ", errorMessage='" + errorMessage + '\'' + '}';
    }
}
