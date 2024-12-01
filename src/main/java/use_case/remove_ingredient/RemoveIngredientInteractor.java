package use_case.remove_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public class RemoveIngredientInteractor implements RemoveIngredientInputBoundary{
    private final RemoveIngredientDataAccessInterface removeIngredientUserDataAccessInterface;
    private final RemoveIngredientOutputBoundary removeIngredientOutputBoundary;

    public RemoveIngredientInteractor(RemoveIngredientDataAccessInterface removeIngredientUserDataAccessInterface,
                                   RemoveIngredientOutputBoundary removeIngredientOutputBoundary) {
        this.removeIngredientUserDataAccessInterface = removeIngredientUserDataAccessInterface;
        this.removeIngredientOutputBoundary = removeIngredientOutputBoundary;
    }

    @Override
    public void execute(RemoveIngredientInputData removeIngredientInputData){
        Fridge fridge = removeIngredientInputData.getFridge();
        String toRemoveName = removeIngredientInputData.getName();

        fridge.removeIngredient(toRemoveName);
        removeIngredientUserDataAccessInterface.removeIngredient(fridge, toRemoveName);

        final RemoveIngredientOutputData removeIngredientOutputData = new RemoveIngredientOutputData(fridge, false);

        removeIngredientOutputBoundary.prepareSuccessView(removeIngredientOutputData);
    }
}
