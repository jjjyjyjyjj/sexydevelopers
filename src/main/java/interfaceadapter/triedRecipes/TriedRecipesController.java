package interface_adapter.triedRecipes;


import interface_adapter.LoggedInState;
import use_case.tried_recipes.TriedRecipesInputBoundary;
import use_case.tried_recipes.TriedRecipesOutputBoundary;
import entity.Recipe;

public class TriedRecipesController {
    private final TriedRecipesInputBoundary triedRecipesInput;
    private TriedRecipesViewModel viewModel;

    public TriedRecipesController(TriedRecipesInputBoundary triedRecipesInput) {
        this.triedRecipesInput = triedRecipesInput;
    }

    public void setViewModel(TriedRecipesViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void addRecipe(String username, Recipe recipe) {
        triedRecipesInput.addRecipeToTriedRecipes(username, recipe);
        if (viewModel != null) {
            viewModel.getState().getTriedRecipes().addRecipe(recipe);
            viewModel.firePropertyChanged();
        }
    }

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
