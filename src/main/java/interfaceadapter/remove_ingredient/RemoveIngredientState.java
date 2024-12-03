package interfaceadapter.remove_ingredient;

/**
 * The state for the Add Ingredient View Model.
 */
public class RemoveIngredientState {
    private String name = "";
    private String removeError;

    /**
     * Returns name of removed ingredient.
     * @return name of ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of removed ingredient.
     * @param name name of ingredient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the error messge of this use case.
     * @return error message
     */
    public String getRemoveError() {
        return removeError;
    }

    /**
     * Sets the error message of this use case.
     * @param removeError error message
     */
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
