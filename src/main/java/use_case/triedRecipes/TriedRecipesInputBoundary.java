package use_case.triedRecipes;

import entity.Recipe;

/**
 * Input Boundary for Tried Recipes Use Case.
 */
public interface TriedRecipesInputBoundary {
    /**
     * Adds a recipe to the user's tried recipes list.
     * @param username current user
     * @param recipe recipe tried
     */
    void addRecipeToTriedRecipes(String username, Recipe recipe);

    /**
     * Returns the list of recipes tried by the user.
     * @param username current user
     * @param presenter output boundary of the use case
     */
    void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter);
}
