package interface_adapter.recipeRecommendation;

import entity.Recipe;
import interface_adapter.LoggedInState;
import use_case.recipe_recommender.RecipeRecOutputBoundary;
import use_case.recipe_recommender.RecipeRecOutputData;

import java.util.List;

/**
 * RecipeRecPresenter prepares the output data from the recipe recommendation use case
 * for display in the user interface.
 */
public class RecipeRecPresenter implements RecipeRecOutputBoundary {
    private final RecipeRecViewModel recipeRecViewModel;

    public RecipeRecPresenter(RecipeRecViewModel recipeRecViewModel) {
        this.recipeRecViewModel = recipeRecViewModel;
    }

    /**
     * Prepares the success view for the Recipe Recommendation Use Case.
     *
     * @param outputData The output data containing the recommended recipes.
     */
    @Override
    public void prepareSuccessView(RecipeRecOutputData outputData) {
        final LoggedInState loggedInState = recipeRecViewModel.getState();
        List<Recipe> recommendedRecipes = outputData.getRecommendedRecipes();
        loggedInState.setRecommendedRecipes(recommendedRecipes);

        recipeRecViewModel.firePropertyChanged("recipeRecommendation");
    }

    /**
     * Prepares the failure view for the Recipe Recommendation Use Case.
     *
     * @param errorMessage The explanation of the failure.
     */
    @Override
    public void prepareFailView(String errorMessage) {
        final LoggedInState loggedInState = recipeRecViewModel.getState();
        loggedInState.setRecipeRecommendationError(errorMessage);
    }

    /**
     * Presents the next recommended recipe to the view.
     *
     * @param recipe The next recipe to be displayed.
     */
    @Override
    public void presentNextRecipe(Recipe recipe) {
        final LoggedInState loggedInState = recipeRecViewModel.getState();

        // Update the state with the next recipe to be shown
        loggedInState.setCurrentRecipe(recipe);

        // Notify the view that the next recipe is ready
        recipeRecViewModel.firePropertyChanged("nextRecipe");
    }

    /**
     * Presents an error message to the view.
     *
     * @param errorMessage The error message to be displayed.
     */
    @Override
    public void presentError(String errorMessage) {
        final LoggedInState loggedInState = recipeRecViewModel.getState();

        // Set the error message in the state
        loggedInState.setErrorMessage(errorMessage);

        // Notify the view that there is an error
        recipeRecViewModel.firePropertyChanged("errorMessage");
    }
}
