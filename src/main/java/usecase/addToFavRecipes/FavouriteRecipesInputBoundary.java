package usecase.addToFavRecipes;

/**
 * The Add a Recipe to Favourite Recipes List Use Case.
 */
public interface FavouriteRecipesInputBoundary {
    /**
    * Execute Use Case of adding a new recipe to Favourite Recipes List.
    *
    * @param favouriteRecipesInputData the input data for this use case
    */
    void execute(FavouriteRecipesInputData favouriteRecipesInputData);
}
