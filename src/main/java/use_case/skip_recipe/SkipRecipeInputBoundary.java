package use_case.skip_recipe;

public interface SkipRecipeInputBoundary {

    /**
     * Execute the Skip Recipe Use Case.
     * @param skipRecipeInputData the input data for this use case
     */
    void execute(SkipRecipeInputData skipRecipeInputData);

}
