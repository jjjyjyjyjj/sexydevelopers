package use_case.triedRecipes;

import data_access.FileUserDataAccessObject;
import entity.CommonRecipe;
import entity.PantryPalUser;
import entity.Recipe;
import interface_adapter.triedRecipes.TriedRecipesViewModel;

import java.util.List;

/**
 * Interactor for managing the tried recipes use case.
 */
public class TriedRecipesInteractor implements TriedRecipesInputBoundary {

    private final FileUserDataAccessObject userDataAccess;
    private final TriedRecipesViewModel viewModel;

    public TriedRecipesInteractor(FileUserDataAccessObject userDataAccess, TriedRecipesViewModel viewModel) {
        this.userDataAccess = userDataAccess;
        this.viewModel = viewModel;
    }

    @Override
    public void addRecipeToTriedRecipes(String username, CommonRecipe recipe) {
        if (username == null || username.isEmpty()) {
            viewModel.getState().setErrorMessage("Username cannot be empty.");
            viewModel.firePropertyChanged();
            return;
        }

        PantryPalUser user = userDataAccess.get(username);
        if (user == null) {
            viewModel.getState().setErrorMessage("User not found: " + username);
            viewModel.firePropertyChanged();
            return;
        }

        user.getTriedRecipes().addRecipe(recipe);
        userDataAccess.save(user);

        viewModel.getState().setErrorMessage(null); // Clear error message on success
        viewModel.firePropertyChanged();
    }

    @Override
    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
        if (username == null || username.isEmpty()) {
            viewModel.getState().setErrorMessage("Username cannot be empty.");
            viewModel.firePropertyChanged();
            return;
        }

        PantryPalUser user = userDataAccess.get(username);
        if (user == null) {
            viewModel.getState().setErrorMessage("User not found: " + username);
            viewModel.firePropertyChanged();
            return;
        }

        List<Recipe> triedRecipes = user.getTriedRecipes().getRecipes();
        viewModel.getState().setErrorMessage(null);
        presenter.presentTriedRecipes(triedRecipes);
    }
}
