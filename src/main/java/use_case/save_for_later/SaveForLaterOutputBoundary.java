package use_case.save_for_later;


public interface SaveForLaterOutputBoundary {
    /**
     * Prepares the success view for the Save For Later Use Case.
     *
     * @param outputData the output data
     */
    void prepareSuccessView(SaveForLaterOutputData outputData);

    /**
     * Prepares the failure view for the Save For Later Use Case.
     *
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}