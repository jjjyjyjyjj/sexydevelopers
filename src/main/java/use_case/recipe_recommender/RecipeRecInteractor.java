package use_case.recipe_recommender;

import api.recipeFinderInterface;
import entity.CommonIngredient;
import entity.CommonRecipe;
import entity.Ingredient;
import entity.Recipe;
import interface_adapter.recipeRecommendation.RecipeRecState;

import java.util.ArrayList;
import java.util.List;

public class RecipeRecInteractor implements RecipeRecInputBoundary {
    private final RecipeRecUserDataAccessInterface userDataAccess;
    private final RecipeRecOutputBoundary outputBoundary;
    private final recipeFinderInterface recipeFinder;
    private final RecipeRecState state;

    public RecipeRecInteractor(RecipeRecUserDataAccessInterface userDataAccess,
                               RecipeRecOutputBoundary outputBoundary,
                               recipeFinderInterface recipeFinder,
                               RecipeRecState state) {
        this.userDataAccess = userDataAccess;
        this.outputBoundary = outputBoundary;
        this.recipeFinder = recipeFinder;
        this.state = state;
    }

    @Override
    public void fetchNextRecipe() {
        try {
            // Fetch ingredients from user's fridge
            ArrayList<Ingredient> ingredients = userDataAccess.getFridgeIngredients();

            // Fetch recommended recipes using the recipe API
            List<Recipe> recipes = recipeFinder.getRecipeByIngredient((ingredients),
                    1, // Number of recipes to fetch
                    1,  // Maximize used ingredients
                    true // Ignore pantry items
            );

            // Filter out skipped recipes
            recipes.removeIf(recipe -> state.getSkippedRecipeIds().contains(recipe.getID()));

            if (!recipes.isEmpty()) {
                // Set the next recipe
                Recipe nextRecipe = recipes.get(0);
                state.setCurrentRecipe(nextRecipe);

                // Pass the updated state to the presenter
                outputBoundary.presentNextRecipe(nextRecipe);
            } else {
                // Handle case where no recipes are found
                state.setErrorMessage("No recipes found for your ingredients.");
                outputBoundary.presentError(state.getErrorMessage());
            }
        } catch (Exception e) {
            // Handle API errors
            state.setErrorMessage("Failed to fetch recipes. Please try again later.");
            outputBoundary.presentError(state.getErrorMessage());
        }
    }

    @Override
    public void skipCurrentRecipe() {
    }

}