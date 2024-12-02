package usecase.recipe_recommender;

import api.recipeFinderInterface;
import entity.*;
import interfaceadapter.recipeRecommendation.RecipeRecState;

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
    public void fetchNextRecipe(RecipeRecInputData inputData) {
        try {
            User user = inputData.getCurrentUser();
            // Fetch ingredients from user's fridge
            ArrayList<Ingredient> ingredients = inputData.getIngredients();

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
                Recipe recipe = recipes.get(0);
                state.setCurrentRecipe(recipe);

                // Pass the updated state to the presenter
                RecipeRecOutputData nextRecipe = new RecipeRecOutputData(recipe,false);
                outputBoundary.prepareSuccessView(nextRecipe);
            } else {
                // Handle case where no recipes are found
                state.setErrorMessage("No recipes found for your ingredients.");
                outputBoundary.prepareFailView(state.getErrorMessage());
            }
        } catch (Exception e) {
            // Handle API errors
            state.setErrorMessage("Failed to fetch recipes. Please try again later.");
            outputBoundary.prepareFailView(state.getErrorMessage());
        }
    }
}