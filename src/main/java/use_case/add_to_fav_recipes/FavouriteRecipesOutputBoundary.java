package use_case.add_to_fav_recipes;

/**
 * The output boundary for the Adding A Recipe to Favourite Recipes List Use Case.
 */
public interface FavouriteRecipesOutputBoundary {
    /**
     * Prepares the success view for the Favourite Recipes Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(FavouriteRecipesOutputData outputData);

    /**
     * Prepares the failure view for the Favourite Recipes Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}