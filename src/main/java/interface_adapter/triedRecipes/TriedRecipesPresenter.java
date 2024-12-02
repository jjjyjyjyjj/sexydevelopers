package interface_adapter.triedRecipes;

import entity.Recipe;
import usecase.tried_recipes.TriedRecipesOutputBoundary;
import java.util.List;

public class TriedRecipesPresenter implements TriedRecipesOutputBoundary {

    @Override
    public void presentTriedRecipes(List<Recipe> triedRecipes) {
        // Format the tried recipes for the view
        for (Recipe recipe : triedRecipes) {
            System.out.println("Tried Recipe: " + recipe.getName());
        }
    }
}
