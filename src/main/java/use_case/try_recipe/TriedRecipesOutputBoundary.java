package use_case.try_recipe;

import entity.Recipe;

import java.util.List;

public interface TriedRecipesOutputBoundary {
    void presentTriedRecipes(List<Recipe> triedRecipes);
}
