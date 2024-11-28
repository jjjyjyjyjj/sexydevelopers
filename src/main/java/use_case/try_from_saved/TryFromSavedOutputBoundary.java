package use_case.try_from_saved;

public interface TryFromSavedOutputBoundary {
    /**
     * Prepares the success view for the Skip Recipe Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(TryFromSavedOutputData outputData);

    /**
     * Prepares the failure view for the Skip Recipe Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
