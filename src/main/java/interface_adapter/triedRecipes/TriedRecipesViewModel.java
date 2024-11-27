package interface_adapter.triedRecipes;

import interface_adapter.ViewModel;

public class TriedRecipesViewModel extends ViewModel<TriedRecipesState> {

    public static final String TITLE_LABEL = "Tried Recipes";

    public TriedRecipesViewModel() {
        super("tried recipes");
        setState(new TriedRecipesState());
    }
}
