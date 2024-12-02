package interface_adapter.fridge;

import interface_adapter.LoggedInState;
import interface_adapter.ViewModel;

public class FridgeViewModel extends ViewModel<LoggedInState> {
    public FridgeViewModel() {
        super("fridge");
        setState(new LoggedInState());
    }
}
