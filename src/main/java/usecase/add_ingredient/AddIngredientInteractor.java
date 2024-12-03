package usecase.add_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.IngredientFactory;
import entity.User;

/**
 * Interactor for Add Ingredient Use Case.
 */
public class AddIngredientInteractor implements AddIngredientInputBoundary {
    private final AddIngredientDataAccessInterface addIngredientDataAccessInterface;
    private final AddIngredientOutputBoundary addIngredientOutputBoundary;
    private final IngredientFactory ingredientFactory;

    public AddIngredientInteractor(AddIngredientDataAccessInterface addIngredientDataAccessInterface,
                                   AddIngredientOutputBoundary addIngredientOutputBoundary,
                                   IngredientFactory ingredientFactory) {
        this.addIngredientDataAccessInterface = addIngredientDataAccessInterface;
        this.addIngredientOutputBoundary = addIngredientOutputBoundary;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void execute(AddIngredientInputData addIngredientInputData) {
        User user = addIngredientInputData.getUser();
        Fridge fridge = user.getFridge();
        Ingredient toAddIngredient = ingredientFactory.create(addIngredientInputData.getName(),
                addIngredientInputData.getUnit(), addIngredientInputData.getQuantity());

        if (fridge.hasIngredient(toAddIngredient)) {
            addIngredientOutputBoundary.prepareFailView("this ingredient already exists");
        }
        else {
            addIngredientDataAccessInterface.addIngredient(user, toAddIngredient);
            final AddIngredientOutputData addIngredientOutputData = new AddIngredientOutputData(user,
                    false);
            addIngredientOutputBoundary.prepareSuccessView(addIngredientOutputData);
        }
    }

    @Override
    public void switchToFridgeView() {
        addIngredientOutputBoundary.switchToFridgeView();
    }
}
