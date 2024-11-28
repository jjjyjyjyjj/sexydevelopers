package interface_adapter.saveforlater;

import entity.Recipe;
import entity.User;
import use_case.add_to_favrecipes.FavouriteRecipesInputBoundary;
import use_case.add_to_favrecipes.FavouriteRecipesInputData;
import use_case.saveforlater.SaveForLaterInputBoundary;
import use_case.saveforlater.SaveForLaterInputData;

public class SaveForLaterController {
    private final SaveForLaterInputBoundary saveForLaterUseCaseInteractor;

    public SaveForLaterController(SaveForLaterInputBoundary saveForLaterUseCaseInteractor) {
        this.saveForLaterUseCaseInteractor = saveForLaterUseCaseInteractor;
    }

    /**
     * Executes the Favourite Recipe Use Case.
     * @param recipe the new recipe that is favourited
     * @param username the username whose favourite recipes list is being changed
     */
    public void execute(Recipe recipe, User username) {
        final SaveForLaterInputData saveForLaterInputData = new SaveForLaterInputData(username.getUsername(), recipe);

        saveForLaterUseCaseInteractor.execute(saveForLaterInputData);
    }
}
