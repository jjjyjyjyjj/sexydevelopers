package entity;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The representation of a set of saved recipes in our program.
 */

@JsonDeserialize(using = SavedRecipesDeserializer.class)
public interface SavedRecipes {
    /**
    * Returns the list of saved recipes.
    * @return the list of saved recipes.
    */
    List<Recipe> getRecipes();

    /**
     * Add a recipe to the list of saved recipes.
     * @param recipe recipe added
     */
    void addRecipe(Recipe recipe);

    /**
     * Remove a recipe from the lsit of saved recipes.
     * @param recipe recipe to be removed
     */
    void removeRecipe(Recipe recipe);
}
