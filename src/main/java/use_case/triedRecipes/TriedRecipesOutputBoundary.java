package use_case.triedRecipes;

import entity.Recipe;

import java.util.List;

public interface TriedRecipesOutputBoundary {
    void presentTriedRecipes(List<Recipe> triedRecipes);
}
