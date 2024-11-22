package interface_adapter.triedRecipes;

import entity.CommonRecipe;
import use_case.triedRecipes.TriedRecipesInputBoundary;
import use_case.triedRecipes.TriedRecipesOutputBoundary;

public class TriedRecipesController {
    private final TriedRecipesInputBoundary triedRecipesInput;

    public TriedRecipesController(TriedRecipesInputBoundary triedRecipesInput) {
        this.triedRecipesInput = triedRecipesInput;
    }

    public void addRecipe(String username, CommonRecipe recipe) {
        triedRecipesInput.addRecipeToTriedRecipes(username, recipe);
    }

    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
        triedRecipesInput.getTriedRecipes(username, presenter);
    }
}
