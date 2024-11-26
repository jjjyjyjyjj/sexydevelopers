package entity;

import java.util.List;

/**
 * The representation of a set of saved recipes in our program.
 */
public interface SavedRecipes {
    /**
    * Returns the list of saved recipes.
    * @return the list of saved recipes.
    */
    List<Recipe> getRecipes();

    void addRecipe(Recipe recipe);

    void removeRecipe(Recipe recipe);
}
