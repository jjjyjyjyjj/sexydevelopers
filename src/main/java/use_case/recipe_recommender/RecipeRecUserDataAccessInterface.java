package use_case.recipe_recommender;

import entity.CommonIngredient;
import entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public interface RecipeRecUserDataAccessInterface {
    ArrayList<Ingredient> getFridgeIngredients();
}
