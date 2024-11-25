package api;

import entity.CommonIngredient;
import entity.CommonRecipe;

import java.io.IOException;
import java.util.List;

/**
 * recipeFinderInterface is an interface that defines the methods that the recipeFinder class must implement.
 */
public interface recipeFinderInterface {

    /**
     * A method that returns a list of recipes that can be made using ingredients in our "fridge"
     * Note: Recipes contain no MORE ingredients than what we have, can be LESS
     * Note: All recipes include an id, images, imageType, likes, missedIngredientCount, missedIngredients
     *
     * @param ingredients  a comma-separated list of ingredients that the recipes should contain.
     * @param number       the maximum number of recipes to return (between 1 and 100). Defaults to 10.
     * @param ranking      whether to maximize used ingredients (1) or minimize missing ingredients (2) first.
     * @param ignorePantry whether to ignore typical pantry items, such as water, salt, flour, etc.
     * @return the list of recipes that can be made with given ingredients
     */
    List<CommonRecipe> getRecipeByIngredient(List<CommonIngredient> ingredients, int number, int ranking, boolean ignorePantry) throws IOException;

}
