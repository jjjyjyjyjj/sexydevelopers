package usecase.recipe_recommender;

/**
 * Input boundary interface for the Recipe Recommendation use case.
 * Defines methods that the interactor must implement.
 */
public interface RecipeRecInputBoundary {
    /**
     * Fetch the next recommended recipe based on the user's fridge contents.
     */
    void fetchNextRecipe(RecipeRecInputData inputData);
}

