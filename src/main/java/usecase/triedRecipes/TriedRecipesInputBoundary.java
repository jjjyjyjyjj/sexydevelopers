package usecase.triedRecipes;

import entity.Recipe;

public interface TriedRecipesInputBoundary {
    void addRecipeToTriedRecipes(String username, Recipe recipe);
    void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter);
}
