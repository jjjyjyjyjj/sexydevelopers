package interfaceadapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import entity.*;

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
    private String name = "";
    private String unit = "";
    private double quantity = 0;
    private String addError;

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
        this.user = new PantryPalUser(username, password);
        this.fridge = new CommonFridge();
        this.triedRecipes = new TriedRecipes();
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
        System.out.println("Setting Current Recipe: " + (recipe != null ? recipe.getName() : "null")); // Log the update
        this.currentRecipe = recipe;
    }

    public void setErrorMessage(String errorMessage) {
        this.savedRecipesError = errorMessage;
    }

    public List<Ingredient> getFridgeContents() {
        System.out.println("Accessing fridge contents: " + this.fridge.getIngredients());
        return this.fridge.getIngredients();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getAddError() {
        return addError;
    }

    public void setAddError(String addError) {
        this.addError = addError;
    }
}
