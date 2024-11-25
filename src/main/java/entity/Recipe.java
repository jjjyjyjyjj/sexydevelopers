package entity;

import java.util.List;

/**
 * The representation of a recipe in our program.
 */
public interface Recipe {

    /**
     * Returns the name of the recipe.
     * @return the name of the recipe.
     */
    String getName();

    /**
     * Returns the id of the recipe.
     * @return the id of the recipe.
     */
    String getID();

    /**
     * Returns a list of the ingredients in the recipe.
     * @return a list of the ingredients in the recipe.
     */
    List<Ingredient> getIngredients();

    /**
     * Returns a link to an image of the recipe.
     * @return a link to an image of the recipe.
     */
    String getImage();

    /**
     * Returns a link to the recipe.
     * @return a link to the recipe.
     */
    String getLink();
}
