package interface_adapter.recipeRecommendation;

import api.recipeFinder;

import entity.Ingredient;
import entity.Recipe;
import interface_adapter.LoggedInState;
import interface_adapter.ViewModel;

import java.util.List;

public class RecipeRecViewModel extends ViewModel<LoggedInState> {
    public RecipeRecViewModel() {
        super("home");
        setState(new LoggedInState());
    }

}
