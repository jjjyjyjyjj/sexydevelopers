package api;

import entity.CommonIngredient;
import entity.CommonRecipe;

import java.io.IOException;
import java.util.List;

/**
 * summarizeRecipeInterface is an interface that defines the methods that the recipeFiner class must implement.
 */
public interface summarizeRecipeInterface {
    /**
     * A method that returns a short description of a recipe given the recipe id.
     * Note: Summary may include prep time, nutritional info, serving size, price, course, source website,
     * dietary features, and spoonacular score.
     *
     * @param id the recipe id.
     * @return a short description that summarizes key information about the recipe.
     */
    String getRecipeSummary(int id) throws IOException;
}
