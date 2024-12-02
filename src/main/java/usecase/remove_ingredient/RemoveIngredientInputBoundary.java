package usecase.remove_ingredient;

public interface RemoveIngredientInputBoundary {
    /**
     * /* Execute Use Case of removing an Ingredient from the Fridge.
     * @param removeIngredientInputData the input data for this use case
     */
    void execute(RemoveIngredientInputData removeIngredientInputData);

}
