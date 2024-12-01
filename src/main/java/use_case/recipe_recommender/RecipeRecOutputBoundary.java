package use_case.recipe_recommender;

import entity.CommonRecipe;
import entity.Recipe;

public interface RecipeRecOutputBoundary {
    void prepareSuccessView(RecipeRecOutputData outputData);

    void prepareFailView(String errorMessage);

}
