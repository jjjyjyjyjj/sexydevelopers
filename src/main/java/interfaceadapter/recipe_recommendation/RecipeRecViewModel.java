package interfaceadapter.recipe_recommendation;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

public class RecipeRecViewModel extends ViewModel<LoggedInState> {
    public RecipeRecViewModel() {
        super("home");
        setState(new LoggedInState());
    }

}
