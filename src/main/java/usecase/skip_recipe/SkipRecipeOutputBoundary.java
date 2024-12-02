package usecase.skip_recipe;

public interface SkipRecipeOutputBoundary {
    /**
     * Prepares the success view for the Skip Recipe Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(SkipRecipeOutputData outputData);

    /**
     * Prepares the failure view for the Skip Recipe Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
