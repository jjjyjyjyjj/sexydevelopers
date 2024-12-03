package usecase.triedRecipes;

import java.util.List;

import entity.Recipe;

/**
 * Output Boundary for Tried Recipes.
 */
public interface TriedRecipesOutputBoundary {
    /**
     * Presents the list of user's tried recipes.
     * @param triedRecipes list of tried recipes
     */
    void presentTriedRecipes(List<Recipe> triedRecipes);
}
