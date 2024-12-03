package use_case.remove_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public interface RemoveIngredientDataAccessInterface {

    void save(User user);
    /**
     * Updates the system to record this removed ingredient.
     * @param user the user whose fridge the ingredient is being removed from.
     * @param name the name of the ingredient being removed.
     */
    void removeIngredient(User user, String name);

    void addIngredient(User user, Ingredient ingredient);

    boolean existsByIngredient(Ingredient ingredient, User user);
}
