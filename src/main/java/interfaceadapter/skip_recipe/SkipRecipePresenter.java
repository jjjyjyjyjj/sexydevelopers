package interfaceadapter.skip_recipe;

import interfaceadapter.LoggedInViewModel;
import usecase.skip_recipe.SkipRecipeOutputBoundary;
import usecase.skip_recipe.SkipRecipeOutputData;

public class SkipRecipePresenter implements SkipRecipeOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;

    public SkipRecipePresenter(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(SkipRecipeOutputData outputData) {
        // currently there isn't anything to change based on the output data,
        // since the output data only contains the username, which remains the same.
        // We still fire the property changed event, but just to let the view know that
        // the user chose to skip this recipe.
        loggedInViewModel.firePropertyChanged("skip recipe");

    }

    @Override
    public void prepareFailView(String error) {
        // note: this use case currently can't fail
    }
}
