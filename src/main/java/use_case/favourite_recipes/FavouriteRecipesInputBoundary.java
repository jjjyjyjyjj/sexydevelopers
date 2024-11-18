package use_case.favourite_recipes;

/**
 * The Favourite CommonRecipe Use Case.
 */
public interface FavouriteRecipesInputBoundary {

    /**
     * Execute the Favourite CommonRecipe Use Case.
     * @param favouriteRecipesInputData the input data for this use case
     */
    void execute(FavouriteRecipesInputData favouriteRecipesInputData);

}
