package use_case.try_from_saved;

import entity.Recipe;
import use_case.skip_recipe.SkipRecipeInputBoundary;
import use_case.skip_recipe.SkipRecipeInputData;
import use_case.skip_recipe.SkipRecipeUserDataAccessInterface;

public class TryFromSavedInteractor implements SkipRecipeInputBoundary {
    private final SkipRecipeUserDataAccessInterface userDataAccessObject;
    private final TryFromSavedOutputBoundary userPresenter;

    public TryFromSavedInteractor(SkipRecipeUserDataAccessInterface skipRecipeUserDataAccessInterface,
                                  TryFromSavedOutputBoundary skipRecipeOutputBoundary) {
        this.userDataAccessObject = skipRecipeUserDataAccessInterface;
        this.userPresenter = skipRecipeOutputBoundary;
    }

    @Override
    public void execute(TryFromSavedInputData skipRecipeInputData) {
        final Recipe recommended_recipe = skipRecipeInputData.getRecipe();
        // what to do with the recommended recipe?
        userDataAccessObject.skipRecipe();

        final TryFromSavedOutputData skipRecipeOutputData = new TryFromSavedOutputData(false);
        userPresenter.prepareSuccessView(skipRecipeOutputData);
    }

    @Override
    public void execute(SkipRecipeInputData skipRecipeInputData) {

    }
}
