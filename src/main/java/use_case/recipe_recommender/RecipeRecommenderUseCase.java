package use_case.recipe_recommender;

import api.recipeFinderInterface;
import entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RecipeRecommenderUseCase class.
 */
public final class RecipeRecommenderUseCase {
    private final recipeFinderInterface recipeFinder;
    private List<Recipe> recommendedRecipes;
    private final ArrayList<Ingredient> ingredients;

    public RecipeRecommenderUseCase(recipeFinderInterface recipeFinder, Fridge fridge) {
        this.recipeFinder = recipeFinder;
        this.recommendedRecipes = new ArrayList<>();
        this.ingredients = fridge.getIngredients();
    }

    public List<Recipe> getRecommendedRecipes() throws IOException {
        this.recommendedRecipes = recipeFinder.getRecipeByIngredient(
                ingredients, 5,2, true);
        return recommendedRecipes;
    }
}
/* return a list of recipes that will be shown to the user*/
