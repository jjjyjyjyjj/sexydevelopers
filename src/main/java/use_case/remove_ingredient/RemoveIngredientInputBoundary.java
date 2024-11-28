package use_case.remove_ingredient;

import use_case.add_ingredient.AddIngredientInputData;

public interface RemoveIngredientInputBoundary {
    /**
     * /* Execute Use Case of removing an Ingredient from the Fridge.
     * @param removeIngredientInputData the input data for this use case
     */
    void execute(RemoveIngredientInputData removeIngredientInputData);

}
