package interfaceadapter.triedRecipes;

import java.util.List;

import entity.Recipe;
import use_case.tried_recipes.TriedRecipesOutputBoundary;

/**
 * Presenter for Tried Recipes Use Case.
 */
public class TriedRecipesPresenter implements TriedRecipesOutputBoundary {

    @Override
    public void presentTriedRecipes(List<Recipe> triedRecipes) {
        // Format the tried recipes for the view
        for (Recipe recipe : triedRecipes) {
            System.out.println("Tried Recipe: " + recipe.getName());
        }
    }
}
