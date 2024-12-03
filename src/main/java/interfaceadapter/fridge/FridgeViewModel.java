package interfaceadapter.fridge;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

/**
 * The View Model for Fridge.
 */
public class FridgeViewModel extends ViewModel<LoggedInState> {
    public FridgeViewModel() {
        super("fridge");
        setState(new LoggedInState());
    }
}
