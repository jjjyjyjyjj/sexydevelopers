package use_case.favourite_recipes;

/**
 * The Favourite Recipe Use Case.
 */
public interface FavouriteRecipesInputBoundary {

    /**
     * Execute the Favourite Recipe Use Case.
     * @param favouriteRecipesInputData the input data for this use case
     */
    void execute(FavouriteRecipesInputData favouriteRecipesInputData);

}
