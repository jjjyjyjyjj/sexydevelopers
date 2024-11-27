package use_case.skip_recipe;

import entity.Recipe;

public class SkipRecipeInteractor implements SkipRecipeInputBoundary{
    private final SkipRecipeUserDataAccessInterface userDataAccessObject;
    private final SkipRecipeOutputBoundary userPresenter;

    public SkipRecipeInteractor(SkipRecipeUserDataAccessInterface skipRecipeUserDataAccessInterface,
                                    SkipRecipeOutputBoundary skipRecipeOutputBoundary) {
        this.userDataAccessObject = skipRecipeUserDataAccessInterface;
        this.userPresenter = skipRecipeOutputBoundary;
    }

    @Override
    public void execute(SkipRecipeInputData skipRecipeInputData) {
        final Recipe recommended_recipe = skipRecipeInputData.getRecipe();
        // what to do with the recommended recipe?
        userDataAccessObject.skipRecipe();

        final SkipRecipeOutputData skipRecipeOutputData = new SkipRecipeOutputData(false);
        userPresenter.prepareSuccessView(skipRecipeOutputData);
    }

}
