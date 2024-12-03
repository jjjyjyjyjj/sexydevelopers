package usecase.remove_ingredient;

public interface RemoveIngredientOutputBoundary {
    /**
     * Prepares the success view for the Remove Ingredient Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RemoveIngredientOutputData outputData);

    /**
     * Prepares the failure view for the Remove Ingredient Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
