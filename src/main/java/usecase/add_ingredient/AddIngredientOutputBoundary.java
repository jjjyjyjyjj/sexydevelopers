package usecase.add_ingredient;

public interface AddIngredientOutputBoundary {
    /**
     * Prepares the success view for the Add Ingredient Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(AddIngredientOutputData outputData);

    /**
     * Prepares the failure view for the Add Ingredient Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    void switchToFridgeView();
}
