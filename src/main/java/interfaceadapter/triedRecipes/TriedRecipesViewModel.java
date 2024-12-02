package interfaceadapter.triedRecipes;

import interfaceadapter.ViewModel;

public class TriedRecipesViewModel extends ViewModel<TriedRecipesState> {

    public static final String TITLE_LABEL = "Tried Recipes";

    public TriedRecipesViewModel() {
        super("triedRecipes");
        setState(new TriedRecipesState());
    }
}
