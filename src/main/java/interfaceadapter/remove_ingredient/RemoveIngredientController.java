package interfaceadapter.remove_ingredient;

import entity.Fridge;
import entity.User;
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
     * @param user being removed from
     */
    public void execute(String name, User user) {

        final RemoveIngredientInputData removeIngredientInputData = new RemoveIngredientInputData(name, user);

        removeIngredientUseCaseInteractor.execute(removeIngredientInputData);
    }

}
