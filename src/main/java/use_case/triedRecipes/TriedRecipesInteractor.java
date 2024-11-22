package use_case.triedRecipes;

import data_access.FileUserDataAccessObject;
import entity.CommonRecipe;
import entity.PantryPalUser;

import java.util.List;

public class TriedRecipesInteractor implements TriedRecipesInputBoundary {
    private final FileUserDataAccessObject userDataAccess;

    public TriedRecipesInteractor(FileUserDataAccessObject userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    @Override
    public void addRecipeToTriedRecipes(String username, CommonRecipe recipe) {
        PantryPalUser user = userDataAccess.get(username);
        if (user != null) {
            user.getTriedRecipes().addRecipe(recipe);
            userDataAccess.save(user);
        }
    }

    @Override
    public void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter) {
        PantryPalUser user = userDataAccess.get(username);
        if (user != null) {
            List<CommonRecipe> triedRecipes = user.getTriedRecipes().getRecipes();
            presenter.presentTriedRecipes(triedRecipes);
        }
    }
}
