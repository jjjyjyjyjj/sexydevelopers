package usecase.add_ingredient;

/**
 * The input boundary for Add Ingredient Use Case.
 */
public interface AddIngredientInputBoundary {

    /**
     * Execute Use Case of adding an Ingredient to the Fridge.
     * @param addIngredientInputData the input data for this use case
     */
    void execute(AddIngredientInputData addIngredientInputData);

    /**
     * Switches Fridge View.
     */
    void switchToFridgeView();

}
