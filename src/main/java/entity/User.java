package entity;

/**
 * The representation of a user in our program.
 */
public interface User {

    /**
     * Returns the username of the user.
     * @return the username of the user.
     */
    String getUsername();

    /**
     * Returns the password of the user.
     * @return the password of the user.
     */
    String getPassword();

    SavedRecipes getSavedForLater();

    SavedRecipes getFavourited();

    SavedRecipes getTriedRecipes();

    Fridge getFridge();

    void setFridge(Fridge fridge);
}
