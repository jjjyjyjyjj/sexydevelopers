package usecase.add_ingredient;

/**
 * The output boundary for Add Ingredient Use Case.
 */
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

    /**
     * Switches View to Fridge View.
     */
    void switchToFridgeView();
}
