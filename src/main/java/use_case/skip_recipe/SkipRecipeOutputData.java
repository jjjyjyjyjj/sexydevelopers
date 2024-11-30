package use_case.skip_recipe;

/**
 * Output Data for Skip Recipe Use Case.
 */

public class SkipRecipeOutputData {
    private final boolean useCaseFailed;

    public SkipRecipeOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
