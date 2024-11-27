package entity.fridge;

import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FridgeTest {
    private FridgeFactory fridgefactory;
    private Fridge fridge;

    @Test
    public void testAddIngredient() {
        // Arrange
        FridgeFactory fridgeFactory = new CommonFridgeFactory();
        Fridge fridge = fridgeFactory.create();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");

        // Act
        fridge.addIngredient(ingredient);

        // Assert
        Assertions.assertTrue(fridge.getIngredients().contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        // Arrange

        FridgeFactory fridgeFactory = new CommonFridgeFactory();
        Fridge fridge = fridgeFactory.create();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");
        fridge.addIngredient(ingredient);

        // Act
        fridge.removeIngredient(ingredient);

        // Assert
        Assertions.assertFalse(fridge.getIngredients().contains(ingredient));
    }
}
