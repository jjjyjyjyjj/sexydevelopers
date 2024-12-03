package use_case.remove_from_fav_recipes;

/**
 * The output boundary for the Remove a Recipe from Favourite Recipes List Use Case.
 */
public interface RemoveFavRecipeOutputBoundary {
    /**
     * Prepares the success view for the Remove a Recipe from Favourite Recipes List Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RemoveFavRecipeOutputData outputData);

    /**
     * Prepares the failure view for the Remove a Recipe from Favourite Recipes List Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
