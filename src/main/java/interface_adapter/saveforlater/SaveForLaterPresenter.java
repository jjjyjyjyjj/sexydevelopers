package interface_adapter.saveforlater;

import interface_adapter.LoggedInState;
import interface_adapter.login.LoginState;
import use_case.save_for_later.SaveForLaterOutputBoundary;
import use_case.save_for_later.SaveForLaterOutputData;

public class SaveForLaterPresenter implements SaveForLaterOutputBoundary {
    private final SaveForLaterViewModel saveForLaterViewModel;

    public SaveForLaterPresenter(SaveForLaterViewModel saveForLaterViewModel){
        this.saveForLaterViewModel = saveForLaterViewModel;
    }

    /**
     * Prepares the success view for the Remove a Recipe from Favourite Recipes List Use Case.
     *
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(SaveForLaterOutputData outputData) {
        final LoggedInState loggedInState = saveForLaterViewModel.getState();
        loggedInState.setSavedRecipes(outputData.getSavedForLater());
        saveForLaterViewModel.firePropertyChanged("save for later");
    }

    /**
     * Prepares the failure view for the Save For Later Use Case.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        final LoggedInState loggedInState = saveForLaterViewModel.getState();
        loggedInState.setSavedRecipesError(errorMessage);
    }

}
