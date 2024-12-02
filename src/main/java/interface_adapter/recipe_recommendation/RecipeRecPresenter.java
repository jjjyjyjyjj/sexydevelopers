package interface_adapter.recipe_recommendation;

import entity.Recipe;
import interface_adapter.LoggedInState;
import usecase.recipe_recommender.RecipeRecOutputBoundary;
import usecase.recipe_recommender.RecipeRecOutputData;

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
        Recipe recommendedRecipe = outputData.getRecommendedRecipe();
        loggedInState.setRecommendedRecipe(recommendedRecipe);

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
}