package use_case.triedRecipes;

import entity.CommonRecipe;

public interface TriedRecipesInputBoundary {
    void addRecipeToTriedRecipes(String username, CommonRecipe recipe);
    void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter);
}
