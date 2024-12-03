package usecase.recipe_recommender;

import java.util.ArrayList;

import entity.Ingredient;
import entity.User;

/**
 * DAO for Recipe Recommender Use Case.
 */
public interface RecipeRecUserDataAccessInterface {

    /**
     * Gets the ingredients in the User's fridge.
     * @param user Current user
     * @return List of ingredients user has in their fridge
     */
    ArrayList<Ingredient> getFridgeIngredients(User user);
}
