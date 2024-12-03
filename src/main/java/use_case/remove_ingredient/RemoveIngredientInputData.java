package use_case.remove_ingredient;

import entity.Fridge;
import entity.User;

public class RemoveIngredientInputData {
    private final String name;
    private final User user;

    public RemoveIngredientInputData(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }
}
