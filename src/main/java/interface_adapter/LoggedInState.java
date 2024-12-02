package interface_adapter;

import entity.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;


/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private PantryPalUser user;
    private String username = "";
    private String password = "";
    private String passwordError;
    private Fridge fridge;
    private Recipe currentRecipe;
    private SavedRecipes favRecipes;
    private SavedRecipes triedRecipes;
    private SavedRecipes savedforlaterRecipes;
    private List<SavedRecipes> savedForLaterRecipes = new ArrayList<>();
    private ViewManagerModel viewManagerModel;
    private String savedRecipesError;
    private Recipe recommendedRecipe;

    private String viewName = "home";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LoggedInState(LoggedInState copy) {
        user = copy.user;
        username = copy.username;
        password = copy.password;
        passwordError = copy.passwordError;
        fridge = copy.fridge;
        favRecipes = copy.favRecipes;
        triedRecipes = copy.triedRecipes;
        savedforlaterRecipes = copy.savedforlaterRecipes;
        viewName = copy.viewName;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {
        this.user = new PantryPalUser();
        this.fridge = new CommonFridge();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPassword() {
        return password;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public Recipe getCurrentRecipe() {
        return currentRecipe;
    }

    public void setSavedRecipes(SavedRecipes savedRecipe) {
        savedForLaterRecipes.add(savedRecipe);
    }

    public void setSavedRecipesError(String savedRecipesError) {
        this.savedRecipesError = savedRecipesError;
    }

    public SavedRecipes getFavRecipes() {
        return favRecipes;
    }

    public void setFavRecipes(SavedRecipes favRecipes) {
        this.favRecipes = favRecipes;
    }

    public SavedRecipes getTriedRecipes() {
        return triedRecipes;
    }

    public void setTriedRecipes(SavedRecipes triedRecipes) {
        this.triedRecipes = triedRecipes;
    }

    public SavedRecipes getsavedforlaterRecipes() {
        return savedforlaterRecipes;
    }

    public void setsavedforlaterRecipes(SavedRecipes savedforlaterRecipes) {
        this.savedforlaterRecipes = savedforlaterRecipes;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewManagerModel(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void setViewName(String viewName) {
        String oldViewName = this.viewName;
        this.viewName = viewName;

        System.out.println("LoggedInState: ViewName changing from " + oldViewName + " to " + viewName);

        support.firePropertyChange("viewName", oldViewName, viewName);

        if (viewManagerModel != null) {
            viewManagerModel.setState(viewName);
            viewManagerModel.firePropertyChanged();
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public PantryPalUser getUser() {
        return user;
    }

    public void setRecommendedRecipe(Recipe recommendedRecipe) {
        this.recommendedRecipe = recommendedRecipe;
    }

    public void setRecipeRecommendationError(String errorMessage) {
    }

    public void setCurrentRecipe(Recipe recipe) {
        this.currentRecipe = recipe;
    }

    public void setErrorMessage(String errorMessage) {
        this.savedRecipesError = errorMessage;
    }

    public List<Ingredient> getFridgeContents() {
        return this.fridge.getIngredients();
    }
}
