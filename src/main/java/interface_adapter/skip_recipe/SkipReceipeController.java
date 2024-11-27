package interface_adapter.skip_recipe;

import entity.Recipe;
import use_case.skip_recipe.SkipRecipeInputBoundary;
import use_case.skip_recipe.SkipRecipeInputData;

/**
 * Controller for the Skip Recipe Use Case.
 */
public class SkipReceipeController {
    private final SkipRecipeInputBoundary skipRecipeUseCaseInteractor;

    public SkipReceipeController(SkipRecipeInputBoundary skipRecipeUseCaseInteractor) {
        this.skipRecipeUseCaseInteractor = skipRecipeUseCaseInteractor;
    }

    /**
     * Executes the Skip Recipe Use Case.
     * @param recipe the recommended recipe
     */
    public void execute(Recipe recipe) {
        final SkipRecipeInputData skipRecipeInputData = new SkipRecipeInputData(recipe);

        skipRecipeUseCaseInteractor.execute(skipRecipeInputData);
    }
}

