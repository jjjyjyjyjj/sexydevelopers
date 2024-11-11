package use_case;

import api.recipeFinderInterface;
import entity.Fridge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * RecipeRecommenderUseCase class.
 */
public final class RecipeRecommenderUseCase {
    private final recipeFinderInterface recipeFinder;
    private List<Map<String, Object>> recommendedRecipes;

    public RecipeRecommenderUseCase(recipeFinderInterface recipeFinder) {
        this.recipeFinder = recipeFinder;
        this.recommendedRecipes = new ArrayList<>();
    }

    public List<Map<String, Object>> getRecommendedRecipes() throws IOException {

        Map<String, Integer> ingredients = Fridge.getIngredients();
        List<String> groceries = new ArrayList<>(ingredients.keySet());

        this.recommendedRecipes = recipeFinder.getRecipeByIngredient(
                groceries, 5,2, true);
        return recommendedRecipes;
    }
}
/* return a list of recipes that will be shown to the user*/
