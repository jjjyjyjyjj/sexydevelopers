package usecase.tried_recipes;

import entity.Recipe;

import java.util.List;

public interface TriedRecipesOutputBoundary {
    void presentTriedRecipes(List<Recipe> triedRecipes);
}
