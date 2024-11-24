package use_case.recipe_recommender;

import api.recipeFinderInterface;
import entity.CommonFridge;
import entity.CommonIngredient;
import entity.CommonRecipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RecipeRecommenderUseCase class.
 */
public final class RecipeRecommenderUseCase {
    private final recipeFinderInterface recipeFinder;
    private List<CommonRecipe> recommendedRecipes;
    private final ArrayList<CommonIngredient> ingredients;

    public RecipeRecommenderUseCase(recipeFinderInterface recipeFinder, CommonFridge fridge) {
        this.recipeFinder = recipeFinder;
        this.recommendedRecipes = new ArrayList<>();
        this.ingredients = fridge.getIngredients();
    }

    public List<CommonRecipe> getRecommendedRecipes() throws IOException {
        this.recommendedRecipes = recipeFinder.getRecipeByIngredient(
                ingredients, 5,2, true);
        return recommendedRecipes;
    }
}
/* return a list of recipes that will be shown to the user*/
