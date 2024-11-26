package interface_adapter.triedRecipes;

import entity.Recipe;
import use_case.triedRecipes.TriedRecipesOutputBoundary;
import java.util.List;
import entity.CommonRecipe;

public class TriedRecipesPresenter implements TriedRecipesOutputBoundary {

    @Override
    public void presentTriedRecipes(List<Recipe> triedRecipes) {
        // Format the tried recipes for the view
        for (Recipe recipe : triedRecipes) {
            System.out.println("Tried Recipe: " + recipe.getName());
        }
    }
}
