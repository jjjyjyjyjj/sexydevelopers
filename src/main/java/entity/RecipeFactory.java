package entity;

import java.util.List;

/**
 * Factory for creating recipes.
 */
public interface RecipeFactory {
    /**
     * Creates a new Ingredient.
     * @param name the name of the recipe.
     * @param id the id of the recipe.
     * @param image the link to the image of the recipe.
     * @param link the link to the recipe.
     * @return the new ingredient.
     */
    Recipe create(String name, String id, List<Ingredient> ingredients, String image, String link);
}
