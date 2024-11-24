package interface_adapter.triedRecipes;

import use_case.triedRecipes.TriedRecipesOutputBoundary;
import java.util.List;
import entity.CommonRecipe;

public class TriedRecipesPresenter implements TriedRecipesOutputBoundary {

    @Override
    public void presentTriedRecipes(List<CommonRecipe> triedRecipes) {
        // Format the tried recipes for the view
        for (CommonRecipe recipe : triedRecipes) {
            System.out.println("Tried Recipe: " + recipe.getName());
        }
    }
}
