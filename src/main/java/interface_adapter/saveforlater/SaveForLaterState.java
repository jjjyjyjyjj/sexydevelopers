package interface_adapter.saveforlater;

import entity.Recipe;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class SaveForLaterState {
    private User user;
    private List<Recipe> savedForLaterRecipes = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public List<Recipe> getSavedRecipes() {
        return savedForLaterRecipes;
    }

}
