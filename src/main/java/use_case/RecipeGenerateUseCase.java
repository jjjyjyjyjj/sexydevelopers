package use_case;

import api.recipeFinderInterface;
import entity.Recipe;
import entity.Fridge;

import java.util.ArrayList;
import java.util.Map;

/**
 * RecipeGenerateUseCase class.
 */
public class RecipeRecommenderUseCase {
    private final recipeFinderInterface recipeFinderInterface;
    private final Recipe recipe;
    private final ArrayList<String> recommendedRecipes;

    public RecipeRecommenderUseCase(api.recipeFinderInterface recipeFinderInterface, Recipe recipe) {
        this.recipeFinderInterface = recipeFinderInterface;
        this.recipe = recipe;
        this.recommendedRecipes = recommendedRecipes;
    }

    public ArrayList<String> getRecommendedRecipes() {
        Map<String, Integer> ingredients = Fridge.getingredients();
        return recommendedRecipes;
    }
}
/* return a list of recipes that will be shown to the user*/
