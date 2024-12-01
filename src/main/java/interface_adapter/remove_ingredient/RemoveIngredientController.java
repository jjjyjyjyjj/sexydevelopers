package interface_adapter.remove_ingredient;

import entity.Fridge;
import entity.Ingredient;
import use_case.add_ingredient.AddIngredientInputBoundary;
import use_case.add_ingredient.AddIngredientInputData;
import use_case.remove_ingredient.RemoveIngredientInputBoundary;
import use_case.remove_ingredient.RemoveIngredientInputData;

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
