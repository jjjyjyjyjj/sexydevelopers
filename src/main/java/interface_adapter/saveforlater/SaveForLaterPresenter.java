package interface_adapter.saveforlater;

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
        saveForLaterViewModel.firePropertyChanged("save for later");
    }

    @Override
    public void prepareFailureView(String errorMessage) {
    }
}
