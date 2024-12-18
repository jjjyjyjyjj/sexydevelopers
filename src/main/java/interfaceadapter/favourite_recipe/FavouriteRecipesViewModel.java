package interfaceadapter.favourite_recipe;

import interfaceadapter.ViewModel;

/**
 * The View Model for Favourite Recipes.
 */
public class FavouriteRecipesViewModel extends ViewModel<FavouriteRecipesState> {
    public static final String TITLE_LABEL = "Favourite View";
    public static final String FAVOURITE_BUTTON_LABEL = "Add to Favourite";
    public static final String REMOVE_FAVOURITE_BUTTON_LABEL = "Remove from Favourite";

    public FavouriteRecipesViewModel() {
        super("favouriteRecipes");
        setState(new FavouriteRecipesState());
    }
}
