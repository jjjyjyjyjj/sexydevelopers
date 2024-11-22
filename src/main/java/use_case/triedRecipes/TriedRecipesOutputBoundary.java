package use_case.triedRecipes;

import entity.CommonRecipe;

import java.util.List;

public interface TriedRecipesOutputBoundary {
    void presentTriedRecipes(List<CommonRecipe> triedRecipes);
}
