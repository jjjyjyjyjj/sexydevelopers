package interface_adapter.triedRecipes;

import interface_adapter.LoggedInState;
import interface_adapter.ViewModel;

public class TriedRecipesViewModel extends ViewModel<LoggedInState> {

    public static final String TITLE_LABEL = "Tried Recipes";

    public TriedRecipesViewModel() {
        super("triedRecipes");
        setState(new LoggedInState());
    }
}
