package interfaceadapter.triedRecipes;

import java.util.ArrayList;
import java.util.List;

public class TriedRecipesState {
    private String username = "";
    private String errorMessage;
    private List<String> triedRecipes = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getTriedRecipes() {
        return triedRecipes;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setTriedRecipes(List<String> triedRecipes) {
        this.triedRecipes = triedRecipes;
    }
}
