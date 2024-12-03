package interfaceadapter.fridge;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

public class FridgeViewModel extends ViewModel<LoggedInState> {
    public FridgeViewModel() {
        super("fridge");
        setState(new LoggedInState());
    }
}
