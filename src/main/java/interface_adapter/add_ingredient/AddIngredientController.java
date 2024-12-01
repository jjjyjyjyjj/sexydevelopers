package interface_adapter.add_ingredient;

import entity.Fridge;
import entity.Ingredient;
import use_case.add_ingredient.AddIngredientInputBoundary;
import use_case.add_ingredient.AddIngredientInputData;

/**
 * The controller for the Add Ingredient Use Case.
 */
public class AddIngredientController {

    private final AddIngredientInputBoundary addIngredientUseCaseInteractor;

    public AddIngredientController(AddIngredientInputBoundary addIngredientUseCaseInteractor) {
        this.addIngredientUseCaseInteractor = addIngredientUseCaseInteractor;
    }

    /**
     * Executes the Add Ingredient Use Case.
     * @param name the name of the ingredient
     * @param unit the unit of the ingredient
     * @param quantity the quantity of the ingredient
     * @param fridge being added to
     */
    public void execute(String name, String unit, double quantity, Fridge fridge) {

        final AddIngredientInputData addIngredientInputData = new AddIngredientInputData(name, unit, quantity, fridge);

        addIngredientUseCaseInteractor.execute(addIngredientInputData);
    }

}
