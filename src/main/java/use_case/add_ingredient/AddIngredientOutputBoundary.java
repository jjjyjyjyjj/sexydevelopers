package use_case.add_ingredient;

import use_case.change_password.ChangePasswordOutputData;

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
}
