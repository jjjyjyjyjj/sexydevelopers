package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The representation of a user in our program.
 */

@JsonDeserialize(using = UserDeserializer.class)
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

    /**
     * Returns list of the current user's saved recipes.
     * @return list of saved recipes
     */
    SavedRecipes getSavedForLater();

    /**
     * Returns list of the current user's favourited recipes.
     * @return list of favourited recipes
     */
    SavedRecipes getFavourited();

    /**
     * Returns the list of the current user's tried recipes.
     * @return list of user's tried recipes
     */
    SavedRecipes getTriedRecipes();

    /**
     * Returns the current user's fridge.
     * @return user's fridge
     */
    Fridge getFridge();

    /**
     * Setting up the fridge.
     * @param fridge fridge to be setted up
     */
    void setFridge(Fridge fridge);

}
