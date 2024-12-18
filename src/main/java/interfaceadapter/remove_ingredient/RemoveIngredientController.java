package interfaceadapter.remove_ingredient;

import entity.User;
import usecase.remove_ingredient.RemoveIngredientInputBoundary;
import usecase.remove_ingredient.RemoveIngredientInputData;

/**
 * The controller for the Remove Ingredient Use Case.
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
