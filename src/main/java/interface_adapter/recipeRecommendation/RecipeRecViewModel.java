package interface_adapter.recipeRecommendation;

import interface_adapter.ViewModel;

public class RecipeRecViewModel extends ViewModel<RecipeRecState> {
    public RecipeRecViewModel() {
        super("Home Screen");
        setState(new RecipeRecState());
    }
}
