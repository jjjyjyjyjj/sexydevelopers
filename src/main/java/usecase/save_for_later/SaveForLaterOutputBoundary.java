package usecase.save_for_later;

/**
 * The output boundary for the Save for Later Use Case.
 */
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
