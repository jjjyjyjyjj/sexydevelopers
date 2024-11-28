package api;

import entity.Ingredient;

import java.io.IOException;
import java.util.List;

/**
 * searchIngredientsInterface is an interface that defines the methods that the searchIngredients class must implement.
 */
public interface searchIngredientsInterface {

    /**
     * A method that returns a list of valid ingredients when provided a search query.
     *
     * @param query  the partial or full ingredient name
     * @return the list of ingredients that match the query
     */
    List<Ingredient> findIngredients(String query) throws IOException;
}
