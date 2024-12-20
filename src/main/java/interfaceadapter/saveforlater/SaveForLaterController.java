package interfaceadapter.saveforlater;

import entity.Recipe;
import entity.User;
import usecase.save_for_later.SaveForLaterInputBoundary;
import usecase.save_for_later.SaveForLaterInputData;

/**
 * The controller for Save For Later Use Case.
 */
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
        final SaveForLaterInputData saveForLaterInputData = new SaveForLaterInputData(username, recipe);

        saveForLaterUseCaseInteractor.execute(saveForLaterInputData);
    }
}
