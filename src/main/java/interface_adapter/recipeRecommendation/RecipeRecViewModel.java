package interface_adapter.recipeRecommendation;

import interface_adapter.LoggedInState;
import interface_adapter.ViewModel;

public class RecipeRecViewModel extends ViewModel<LoggedInState> {
    public RecipeRecViewModel() {
        super("home");
        setState(new LoggedInState());
    }

}
