package entity;

import java.util.List;

/**
 * Factory for creating recipes.
 */

public class CommonRecipeFactory implements RecipeFactory {
    /**
     * Creates a new CommonRecipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @param ingredients the ingredients of the new recipe
     * @param image the image of the new recipe
     * @return the new recipe
     */
    public CommonRecipe create(String name, String id, List<CommonIngredient> ingredients, String image) {
        return new CommonRecipe(name, id, ingredients, image, link);
    }
}
