package interface_adapter.remove_ingredient;

import interface_adapter.ViewModel;

public class RemoveIngredientViewModel extends ViewModel<RemoveIngredientState> {

    public static final String TITLE_LABEL = "Remove Ingredient View";
    public static final String NAME_LABEL = "Ingredient name";

    public static final String DONE_LABEL = "Done";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public RemoveIngredientViewModel() {
        super("remove ingredient");
        setState(new RemoveIngredientState());
    }
}
