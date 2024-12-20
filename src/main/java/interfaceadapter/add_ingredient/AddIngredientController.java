package interfaceadapter.add_ingredient;

import entity.User;
import usecase.add_ingredient.AddIngredientInputBoundary;
import usecase.add_ingredient.AddIngredientInputData;

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
     * @param user being added to
     */
    public void execute(String name, String unit, double quantity, User user) {

        final AddIngredientInputData addIngredientInputData = new AddIngredientInputData(name, unit, quantity, user);

        addIngredientUseCaseInteractor.execute(addIngredientInputData);
    }

    /**
     * Switches View from Add Ingredient View to Fridge View.
     */
    public void switchToFridgeView() {
        addIngredientUseCaseInteractor.switchToFridgeView();
    }

}
