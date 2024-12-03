package usecase.save_for_later;

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

    /**
     * Returns the list of Saved Recipes.
     * @return list of saved recipes
     */
    public SavedRecipes getSavedForLater() {
        return savedForLater;
    }

    /**
     * Return true if recipe is added successfully .
     * @return true if recipe is added successfully, false otherwise
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Returns a message that recipe had been added successfully.
     * @return message
     */
    public String getMessage() {
        return message;
    }
}
