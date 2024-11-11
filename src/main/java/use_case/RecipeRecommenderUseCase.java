package use_case;

import api.recipeFinderInterface;
import entity.Fridge;
import entity.Ingredient;

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
    private final ArrayList<Ingredient> ingredients;

    public RecipeRecommenderUseCase(recipeFinderInterface recipeFinder, Fridge fridge) {
        this.recipeFinder = recipeFinder;
        this.recommendedRecipes = new ArrayList<>();
        this.ingredients = fridge.getIngredients();
    }

    public List<Map<String, Object>> getRecommendedRecipes() throws IOException {
        this.recommendedRecipes = recipeFinder.getRecipeByIngredient(
                ingredients, 5,2, true);
        return recommendedRecipes;
    }
}
/* return a list of recipes that will be shown to the user*/
