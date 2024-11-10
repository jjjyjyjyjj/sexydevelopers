package use_case;

import api.recipeFinderInterface;
import entity.Recipe;

import java.util.ArrayList;

/**
 * RecipeGenerateUseCase class.
 */
public class RecipeRecommenderUseCase {
    private final recipeFinderInterface recipeFinderInterface;
    private final Recipe recipe;
    private final ArrayList<String> recommendedRecipes;


    public RecipeRecommenderUseCase(recipeFinderInterface recipeFinderInterface, Recipe recipe) {
        this.recipeFinderInterface = recipeFinderInterface;
        this.recipe = recipe;
    }
}
/* return a list of recipes that will be shown to the user*/
