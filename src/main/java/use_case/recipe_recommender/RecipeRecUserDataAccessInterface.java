package use_case.recipe_recommender;

import entity.CommonIngredient;
import entity.Ingredient;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface RecipeRecUserDataAccessInterface {
    /**
     * Gets the Ingredients in the User's fridge
     * @param user Current user
     * @return List of Ingredient user has
     */
    void getFridgeIngredients(User user);
}
