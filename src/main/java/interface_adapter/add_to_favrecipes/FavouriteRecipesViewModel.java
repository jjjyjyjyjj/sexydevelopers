package interface_adapter.favourite_recipes;

import interface_adapter.ViewModel;

public class FavouriteRecipesViewModel extends ViewModel<FavouriteRecipesState> {
    public static final String TITLE_LABEL = "Favourite View";
    public static final String FAVOURITE_BUTTON_LABEL = "Favourite";

    public FavouriteRecipesViewModel() {
        super("favourite");
        setState(new FavouriteRecipesState());
    }
}

// Responsibility: take the Input Data and execute
//the use case, looking up information in the Data
//Access object when necessary and manipulating
//Entities. This might create new data that needs
//to be saved in the Data Access layer.
//When complete, create an Output Data object —
//the use case result — and pass it to the
//Presenter.

//Responsibility: when the View Model is
//updated the View is alerted through a
//callback. The View then displays the new
//information to the user, possibly activating
//another View