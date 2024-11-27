package use_case.saveforlater;

import entity.SavedForLaterRecipes;
import entity.SavedRecipes;

/**
 * Output data for the Save For Later use case.
 */
public class SaveForLaterOutputData {
    private final SavedRecipes savedForLater;
    private final boolean success;
    private final String message;

    public SaveForLaterOutputData(SavedRecipes savedForLater, boolean success, String message) {
        this.savedForLater = savedForLater;
        this.success = success;
        this.message = message;
    }

    public SavedRecipes getSavedForLater() {
        return savedForLater;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
