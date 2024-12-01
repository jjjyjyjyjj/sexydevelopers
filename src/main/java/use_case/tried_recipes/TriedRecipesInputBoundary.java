package use_case.tried_recipes;

import entity.Recipe;

public interface TriedRecipesInputBoundary {
    void addRecipeToTriedRecipes(String username, Recipe recipe);
    void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter);
}
