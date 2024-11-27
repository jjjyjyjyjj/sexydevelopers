package interface_adapter.saveforlater;

import interface_adapter.favourite_recipe.FavouriteRecipesViewModel;
import use_case.remove_from_favrecipes.RemoveFavRecipeOutputData;
import use_case.saveforlater.SaveForLaterInputData;
import use_case.saveforlater.SaveForLaterOutputBoundary;
import use_case.saveforlater.SaveForLaterOutputData;

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
        saveForLaterViewModel.firePropertyChanged("save for later");
    }

    @Override
    public void prepareFailureView(String errorMessage) {
    }
}
