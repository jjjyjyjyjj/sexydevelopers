package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

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

    void addRecipe(Recipe recipe);

    void removeRecipe(Recipe recipe);
}
