package use_case.recipe_recommender;

import entity.CommonRecipe;
import entity.Recipe;

public interface RecipeRecOutputBoundary {
    void presentNextRecipe(Recipe recipe);

    void presentError(String errorMessage);
}
