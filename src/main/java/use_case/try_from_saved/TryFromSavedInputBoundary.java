package use_case.try_from_saved;

import use_case.try_from_saved.TryFromSavedInputData;

public interface TryFromSavedInputBoundary {

    /**
     * Execute the Skip Recipe Use Case.
     * @param tryFromSavedInputData the input data for this use case
     */
    void execute(TryFromSavedInputData tryFromSavedInputData);

}
