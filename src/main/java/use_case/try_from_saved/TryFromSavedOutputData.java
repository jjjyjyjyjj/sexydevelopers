package use_case.try_from_saved;

/**
 * Output Data for Skip Recipe Use Case.
 */

public class TryFromSavedOutputData {
    // insert new recipe?
    private final boolean useCaseFailed;

    public TryFromSavedOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
