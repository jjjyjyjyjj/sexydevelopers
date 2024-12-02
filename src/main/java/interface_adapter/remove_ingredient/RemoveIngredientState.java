package interface_adapter.remove_ingredient;

/**
 * The state for the Add Ingredient View Model.
 */
public class RemoveIngredientState {
    private String name = "";
    private String removeError;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemoveError() {
        return removeError;
    }

    public void setRemoveError(String removeError) {
        this.removeError = removeError;
    }

    @Override
    public String toString() {
        return "RemoveIngredient{"
                + "name='" + name + '\''
                + '}';
    }
}
