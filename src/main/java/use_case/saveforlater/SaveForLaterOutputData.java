package use_case.saveforlater;

import entity.SavedForLater;
import entity.SavedForLaterRecipes;

/**
 * Output data for the Save For Later use case.
 */
public class SaveForLaterOutputData {
    private final SavedForLater savedForLater;
    private final boolean success;
    private final String message;

    public SaveForLaterOutputData(SavedForLaterRecipes savedForLater, boolean success, String message) {
        this.savedForLater = savedForLater;
        this.success = success;
        this.message = message;
    }

    public SavedForLater getSavedForLater() {
        return savedForLater;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
