package interfaceadapter.triedRecipes;

import java.util.ArrayList;
import java.util.List;

/**
 * State of Tried Recipes Use Case.
 */
public class TriedRecipesState {
    private String username = "";
    private String errorMessage;
    private List<String> triedRecipes = new ArrayList<>();

    /**
     * Returns current user's username.
     * @return current user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns Error message for tried recipes use case.
     * @return error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Returns a list of tried recipes.
     * @return list of tried recipes
     */
    public List<String> getTriedRecipes() {
        return triedRecipes;
    }

    /**
     * Setting the user's username.
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setting the error message for tried recipes use case.
     * @param errorMessage error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Setting the list of tried recipes.
     * @param triedRecipes list of tried recipes
     */
    public void setTriedRecipes(List<String> triedRecipes) {
        this.triedRecipes = triedRecipes;
    }
}
