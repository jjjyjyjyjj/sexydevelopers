package usecase.triedRecipes;

import java.util.List;

import data_access.FileUserDataAccessObject;
import entity.Recipe;
import entity.User;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;

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
    public void addRecipeToTriedRecipes(String username, Recipe recipe) {
        if (username == null || username.isEmpty()) {
            viewModel.getState().setErrorMessage("Username cannot be empty.");
            viewModel.firePropertyChanged();
        }

        User user = userDataAccess.get(username);
        if (user == null) {
            viewModel.getState().setErrorMessage("User not found: " + username);
            viewModel.firePropertyChanged();
        }

        user.getTriedRecipes().addRecipe(recipe);
        userDataAccess.save(user);

        // Clear error message on success
        viewModel.getState().setErrorMessage(null);
        viewModel.firePropertyChanged();
    }

    @Override
    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
        if (username == null || username.isEmpty()) {
            viewModel.getState().setErrorMessage("Username cannot be empty.");
            viewModel.firePropertyChanged();
        }

        User user = userDataAccess.get(username);
        if (user == null) {
            viewModel.getState().setErrorMessage("User not found: " + username);
            viewModel.firePropertyChanged();
        }

        List<Recipe> triedRecipes = user.getTriedRecipes().getRecipes();
        viewModel.getState().setErrorMessage(null);
        presenter.presentTriedRecipes(triedRecipes);
    }
}
