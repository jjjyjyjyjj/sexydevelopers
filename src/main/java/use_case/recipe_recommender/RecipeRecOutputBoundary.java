package use_case.recipe_recommender;

import entity.CommonRecipe;

public interface RecipeRecOutputBoundary {
    void presentNextRecipe(CommonRecipe recipe);

    void presentError(String errorMessage);
}
