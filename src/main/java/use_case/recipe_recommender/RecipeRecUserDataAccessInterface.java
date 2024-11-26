package use_case.recipe_recommender;

import entity.CommonIngredient;

import java.util.List;

public interface RecipeRecUserDataAccessInterface {
    List<CommonIngredient> getFridgeIngredients();
}
