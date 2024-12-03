package interfaceadapter.triedRecipes;

import java.util.List;

import entity.Recipe;
import usecase.tried_recipes.TriedRecipesOutputBoundary;

/**
 * The presenter for Tried Recipes Use Case.
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
