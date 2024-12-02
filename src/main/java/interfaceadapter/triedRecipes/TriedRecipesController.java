package interfaceadapter.triedRecipes;


import usecase.tried_recipes.TriedRecipesInputBoundary;
import usecase.tried_recipes.TriedRecipesOutputBoundary;
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
    }

    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
        triedRecipesInput.getTriedRecipes(username, triedRecipes -> {
            TriedRecipesState state = viewModel.getState();
            state.setUsername(username);
            state.setTriedRecipes(triedRecipes.stream()
                    .map(Recipe::getName)
                    .toList());
            viewModel.firePropertyChanged();
        });
    }
}
