package interface_adapter.saveforlater;

import interface_adapter.LoggedInState;
import interface_adapter.ViewModel;

import javax.swing.plaf.nimbus.State;

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
