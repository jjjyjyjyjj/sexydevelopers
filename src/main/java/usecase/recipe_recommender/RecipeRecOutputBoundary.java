package usecase.recipe_recommender;

/**
 * The Output Boundary Interface for Recipe Recommender Use Case.
 */
public interface RecipeRecOutputBoundary {

    /**
     * Prepares success view for Recipe Recommender Use Case.
     * @param outputData output data for this use case
     */
    void prepareSuccessView(RecipeRecOutputData outputData);

    /**
     * Prepares fail view for Recipe Recommender Use Case.
     * @param errorMessage error message for this use case
     */
    void prepareFailView(String errorMessage);

}

