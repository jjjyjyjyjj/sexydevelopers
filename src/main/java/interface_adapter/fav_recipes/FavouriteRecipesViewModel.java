package interface_adapter.fav_recipes;

import interface_adapter.ViewModel;

/**
 * The View Model for Favourirte Recipes.
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
