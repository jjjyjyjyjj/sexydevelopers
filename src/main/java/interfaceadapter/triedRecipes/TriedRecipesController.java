package interfaceadapter.triedRecipes;

import entity.Recipe;
import use_case.tried_recipes.TriedRecipesInputBoundary;
import use_case.tried_recipes.TriedRecipesOutputBoundary;

/**
 * Controller for Tried Recipes Use Case.
 */
public class TriedRecipesController {
    private final TriedRecipesInputBoundary triedRecipesInput;
    private TriedRecipesViewModel viewModel;

    public TriedRecipesController(TriedRecipesInputBoundary triedRecipesInput) {
        this.triedRecipesInput = triedRecipesInput;
    }

    /**
     * Set the Tried Recipes View Model.
     * @param viewModel view model to be set
     */
    public void setViewModel(TriedRecipesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Adds a new recipe to the list of user's tried recipes.
     * @param username current user
     * @param recipe recipe to be added
     */
    public void addRecipe(String username, Recipe recipe) {
        triedRecipesInput.addRecipeToTriedRecipes(username, recipe);
        if (viewModel != null) {
            viewModel.getState().getTriedRecipes().addRecipe(recipe);
            viewModel.firePropertyChanged();
        }
    }

    /**
     * Returns the user's list of tried recipes.
     * @param username current user
     * @param presenter output boundary for this use case
     */
    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
//        triedRecipesInput.getTriedRecipes(username, triedRecipes -> {
//            LoggedInState state = viewModel.getState();
//            state.setUsername(username);
//            state.setTriedRecipes(triedRecipes.stream()
//                    .map(Recipe::getName) // Extract the recipe names
//                    .toList());
//            viewModel.firePropertyChanged(); // Notify the view to refresh
//        });
    }
}
