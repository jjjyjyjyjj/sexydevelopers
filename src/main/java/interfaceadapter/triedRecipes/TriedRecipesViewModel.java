package interfaceadapter.triedRecipes;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

public class TriedRecipesViewModel extends ViewModel<LoggedInState> {

    public static final String TITLE_LABEL = "Tried Recipes";

    public TriedRecipesViewModel() {
        super("triedRecipes");
        setState(new LoggedInState());
    }
}