package interfaceadapter.add_ingredient;

import entity.User;
import interfaceadapter.ViewManagerModel;

import java.beans.PropertyChangeSupport;

/**
 * The State for the Add Ingredient Use Case.
 */
public class AddIngredientState {
    private String name = "";
    private String unit = "";
    private double quantity;
    private String addError;
    private User user;
    private ViewManagerModel viewManagerModel;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    /**
     * Returns the name of the ingredient.
     * @return name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ingredient.
     * @param name name of the ingredient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unit number of ingredient.
     * @return unit number of ingredient
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the unit number of ingredients.
     * @param unit unit number of ingredients
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Returns the quantity of ingredients user has.
     * @return quantity of ingredients user has
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of ingredients user has.
     * @param quantity quantity of ingredients user has.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the error message for this use case.
     * @return error message
     */
    public String getAddError() {
        return addError;
    }

    /**
     * SEt the error message for this use case.
      * @param addError error message
     */
    public void setAddError(String addError) {
        this.addError = addError;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {this.user = user; }

    private String viewName = "add ingredient";

    public String getViewName() {
        return viewName;
    }

    public void setViewManagerModel(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void setViewName(String viewName) {
        String oldViewName = this.viewName;
        this.viewName = viewName;

        support.firePropertyChange("viewName", oldViewName, viewName);

        if (viewManagerModel != null) {
            viewManagerModel.setState(viewName);
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public String toString() {
        return "AddIngredient{"
                + "name='" + name + '\''
                + ", unit='" + unit + '\''
                + ", quantity='" + quantity + '\''
                + '}';
    }
}
