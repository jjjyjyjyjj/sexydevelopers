package use_case.change_quantity;

import use_case.add_ingredient.AddIngredientOutputData;

public interface ChangeQuantityOutputBoundary {
    /**
     * Prepares the success view for the Change Quantity Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(ChangeQuantityOutputData outputData);

    /**
     * Prepares the failure view for the Change Quantity Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
