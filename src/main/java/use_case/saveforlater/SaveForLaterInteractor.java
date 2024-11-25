package use_case.saveforlater;

import entity.*;

/**
 * The Save For Later Interactor.
 */
public class SaveForLaterInteractor implements SaveForLaterInputBoundary {
    private final SaveForLaterUserDataAccessInterface userDataAccessObject;
    private final SaveForLaterOutputBoundary userPresenter;
    private final CommonRecipe newSavedRecipe;

    public SaveForLaterInteractor(SaveForLaterUserDataAccessInterface saveForLaterDataAccessInterface,
                                  SaveForLaterOutputBoundary saveForLaterOutputBoundary,
                                  CommonRecipe newSavedRecipe) {
        this.userDataAccessObject = saveForLaterDataAccessInterface;
        this.userPresenter = saveForLaterOutputBoundary;
        this.newSavedRecipe = newSavedRecipe;
    }

    @Override
    public void execute(SaveForLaterInputData saveForLaterInputData) {
        final PantryPalUser user = userDataAccessObject.getUserById(saveForLaterInputData.getUserId());

        final SavedForLaterRecipes savedForLater = user.getSavedForLater();
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


