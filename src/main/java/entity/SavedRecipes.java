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
    List<CommonRecipe> getRecipes();

    void addRecipe(CommonRecipe recipe);

    void removeRecipe(CommonRecipe recipe);
}
