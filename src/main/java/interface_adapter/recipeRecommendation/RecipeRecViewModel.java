package interface_adapter.recipeRecommendation;

import interface_adapter.login.LoginState;
import interface_adapter.viewModel.ViewModel;

public class RecipeRecViewModel extends ViewModel<RecipeRecState> {
    public RecipeRecViewModel() {
        super("Home Screen");
        setState(new RecipeRecState());
    }
}
