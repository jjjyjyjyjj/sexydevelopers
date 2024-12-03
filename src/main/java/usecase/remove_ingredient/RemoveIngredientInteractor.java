package usecase.remove_ingredient;

import entity.Fridge;
import entity.User;

public class RemoveIngredientInteractor implements RemoveIngredientInputBoundary {
    private final RemoveIngredientDataAccessInterface removeIngredientDataAccessInterface;
    private final RemoveIngredientOutputBoundary removeIngredientOutputBoundary;

    public RemoveIngredientInteractor(RemoveIngredientDataAccessInterface removeIngredientDataAccessInterface,
                                      RemoveIngredientOutputBoundary removeIngredientOutputBoundary) {
        this.removeIngredientDataAccessInterface = removeIngredientDataAccessInterface;
        this.removeIngredientOutputBoundary = removeIngredientOutputBoundary;
    }

    @Override
    public void execute(RemoveIngredientInputData removeIngredientInputData) {
        User user = removeIngredientInputData.getUser();
        Fridge fridge = user.getFridge();
        String toRemoveName = removeIngredientInputData.getName();

        if (!fridge.hasIngredientByName(toRemoveName)) {
            removeIngredientOutputBoundary.prepareFailView("this ingredient does not exist");
        } else {
            removeIngredientDataAccessInterface.removeIngredient(user, toRemoveName);
            final RemoveIngredientOutputData removeIngredientOutputData
                    = new RemoveIngredientOutputData(user, false);
            removeIngredientOutputBoundary.prepareSuccessView(removeIngredientOutputData);
        }
    }
}
