package interface_adapter.add_ingredient;

import interface_adapter.ViewModel;

public class AddIngredientViewModel extends ViewModel<AddIngredientState> {

    public static final String TITLE_LABEL = "Add Ingredient View";
    public static final String NAME_LABEL = "Choose name";
    public static final String UNIT_LABEL = "Choose unit";
    public static final String QUANTITY_LABEL = "Choose quantity";

    public static final String DONE_LABEL = "Done";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public AddIngredientViewModel() {
        super("add ingredient");
        setState(new AddIngredientState());
    }
}
