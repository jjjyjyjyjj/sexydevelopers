package use_case.remove_ingredient;

import entity.Fridge;
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
        User user = removeIngredientInputData.getUser();
        Fridge fridge = user.getFridge();
        String toRemoveName = removeIngredientInputData.getName();

        fridge.removeIngredient(toRemoveName);
        removeIngredientUserDataAccessInterface.removeIngredient(user, toRemoveName);

        final RemoveIngredientOutputData removeIngredientOutputData = new RemoveIngredientOutputData(user, false);

        removeIngredientOutputBoundary.prepareSuccessView(removeIngredientOutputData);
    }
}
