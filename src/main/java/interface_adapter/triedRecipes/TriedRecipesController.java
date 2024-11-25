package interface_adapter.triedRecipes;

import entity.CommonRecipe;
import use_case.triedRecipes.TriedRecipesInputBoundary;
import use_case.triedRecipes.TriedRecipesOutputBoundary;

public class TriedRecipesController {
    private final TriedRecipesInputBoundary triedRecipesInput;
    private TriedRecipesViewModel viewModel;

    public TriedRecipesController(TriedRecipesInputBoundary triedRecipesInput) {
        this.triedRecipesInput = triedRecipesInput;
    }

    public void setViewModel(TriedRecipesViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void addRecipe(String username, CommonRecipe recipe) {
        triedRecipesInput.addRecipeToTriedRecipes(username, recipe);
    }

    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
        triedRecipesInput.getTriedRecipes(username, triedRecipes -> {
            TriedRecipesState state = viewModel.getState();
            state.setUsername(username);
            state.setTriedRecipes(triedRecipes.stream()
                    .map(CommonRecipe::getName)
                    .toList());
            viewModel.firePropertyChanged();
        });
    }
}