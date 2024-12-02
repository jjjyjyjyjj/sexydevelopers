package usecase.recipe_recommender;

import entity.Ingredient;
import entity.User;

import java.util.ArrayList;

public interface RecipeRecUserDataAccessInterface {
    /**
     * Gets the Ingredients in the User's fridge
     * @param user Current user
     * @return List of Ingredient user has
     */
    ArrayList<Ingredient> getFridgeIngredients(User user);
}

