package usecase.save_for_later;

/**
 * Input Boundary for Save for Later Use Case.
 */
public interface SaveForLaterInputBoundary {

    /**
     * Executes Use Case of saving a recipe for later.
     * @param inputData input data
     */
    void execute(SaveForLaterInputData inputData);
}
