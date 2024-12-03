package interfaceadapter.add_ingredient;

import entity.User;
import interfaceadapter.ViewManagerModel;

import java.beans.PropertyChangeSupport;

/**
 * The state for the Add Ingredient View Model.
 */
public class AddIngredientState {
    private String name = "";
    private String unit = "";
    private double quantity = 0;
    private String addError;
    private User user;
    private ViewManagerModel viewManagerModel;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


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
