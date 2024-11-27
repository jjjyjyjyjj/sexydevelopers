package use_case.saveforlater;


import entity.Recipe;
import entity.SavedForLater;
import entity.User;

/**
 * The Save For Later Interactor.
 */
public class SaveForLaterInteractor implements SaveForLaterInputBoundary {
    private final SaveForLaterUserDataAccessInterface userDataAccessObject;
    private final SaveForLaterOutputBoundary userPresenter;
    private final Recipe newSavedRecipe;

    public SaveForLaterInteractor(SaveForLaterUserDataAccessInterface saveForLaterDataAccessInterface,
                                  SaveForLaterOutputBoundary saveForLaterOutputBoundary,
                                  Recipe newSavedRecipe) {
        this.userDataAccessObject = saveForLaterDataAccessInterface;
        this.userPresenter = saveForLaterOutputBoundary;
        this.newSavedRecipe = newSavedRecipe;
    }

    @Override
    public void execute(SaveForLaterInputData saveForLaterInputData) {
        final User user = userDataAccessObject.getUserById(saveForLaterInputData.getUsername());

        final SavedForLater savedForLater = user.getSavedForLater();
        savedForLater.addRecipe(newSavedRecipe);

        userDataAccessObject.updateUserSavedRecipes(user);

        final SaveForLaterOutputData saveForLaterOutputData = new SaveForLaterOutputData(
                savedForLater,
                true,
                "Recipe successfully saved for later."
        );
        userPresenter.prepareSuccessView(saveForLaterOutputData);
    }

}


