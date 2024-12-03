package interfaceadapter.recipeRecommendation;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewModel;

/**
 * The View Model for Recipe recommendation Use Case.
 */
public class RecipeRecViewModel extends ViewModel<LoggedInState> {
    public RecipeRecViewModel() {
        super("home");
        setState(new LoggedInState());
    }

}
