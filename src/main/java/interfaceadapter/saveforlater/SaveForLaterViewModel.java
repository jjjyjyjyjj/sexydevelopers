package interfaceadapter.saveforlater;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

/**
 * The View Model for the Save for Later Use CAse.
 */

public class SaveForLaterViewModel extends ViewModel<LoggedInState> {
    public SaveForLaterViewModel() {
        super("savedForLater");
        setState(new LoggedInState());
    }

    /**
     * Updates system about property that was changed.
     * @param saveForLater the label for the property that was changed
     */
    public void firePropertyChanged(String saveForLater) {

    }
}
