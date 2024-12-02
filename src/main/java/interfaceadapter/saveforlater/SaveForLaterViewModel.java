package interfaceadapter.saveforlater;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

/**
 * The View Model for the Save for Later View.
 */

public class SaveForLaterViewModel extends ViewModel<LoggedInState> {
    public SaveForLaterViewModel() {
        super("savedForLater");
        setState(new LoggedInState());
    }

    public void firePropertyChanged(String saveForLater) {

    }
}
