package interfaceadapter.remove_ingredient;

import entity.Fridge;
import usecase.remove_ingredient.RemoveIngredientInputBoundary;
import usecase.remove_ingredient.RemoveIngredientInputData;

/**
 * The controller for the Add Ingredient Use Case.
 */
public class RemoveIngredientController {

    private final RemoveIngredientInputBoundary removeIngredientUseCaseInteractor;

    public RemoveIngredientController(RemoveIngredientInputBoundary removeIngredientUseCaseInteractor) {
        this.removeIngredientUseCaseInteractor = removeIngredientUseCaseInteractor;
    }

    /**
     * Executes the Remove Ingredient Use Case.
     * @param name the name of the ingredient
     * @param fridge being removed from
     */
    public void execute(String name, Fridge fridge) {

        final RemoveIngredientInputData removeIngredientInputData = new RemoveIngredientInputData(name, fridge);

        removeIngredientUseCaseInteractor.execute(removeIngredientInputData);
    }

}
