package entity;

import java.util.List;

/**
 * Factory for creating recipes.
 */

public class RecipeFactory {
    /**
     * Creates a new Recipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @param ingredients the ingredients of the new recipe
     * @param image the image of the new recipe
     * @return the new recipe
     */
    public Recipe create(String name, String id, List<Ingredient> ingredients, String image) {
        return new Recipe(name, id, ingredients, image);
    }
}
