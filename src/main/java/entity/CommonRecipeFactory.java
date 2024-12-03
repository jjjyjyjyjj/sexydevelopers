package entity;

import java.util.List;

/**
 * Factory for creating Common Recipe entity.
 */

public class CommonRecipeFactory implements RecipeFactory {
    /**
     * Creates a new CommonRecipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @param ingredients the ingredients of the new recipe
     * @param image the image of the new recipe
     * @param link the link to the recipe
     * @return the new recipe
     */

    @Override
    public Recipe create(String name, int id, List<Ingredient> ingredients, String image, String link) {
        return new CommonRecipe(name, id, ingredients, image, link);
    }
}
