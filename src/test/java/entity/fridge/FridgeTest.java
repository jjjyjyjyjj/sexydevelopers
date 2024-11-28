package entity.fridge;

import entity.*;
import entity.exceptions.IngredientNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class FridgeTest {

    @Test
    public void testHasIngredient() {
        // Arrange
        FridgeFactory fridgeFactory = new CommonFridgeFactory();
        Fridge fridge = fridgeFactory.create();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");

        // Act
        fridge.addIngredient(ingredient);

        // Assert
        Assertions.assertTrue(fridge.hasIngredient(ingredient));
    }

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

    @Test
    public void testRemoveIngredientExceptionHandling() {
        // Arrange
        FridgeFactory fridgeFactory = new CommonFridgeFactory();
        Fridge fridge = fridgeFactory.create();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");

        // Act & Assert
        assertDoesNotThrow(() -> fridge.removeIngredient(ingredient));
    }

    @Test
    public void testCheckFridgeIngredientExists() {
        // Arrange
        FridgeFactory fridgeFactory = new CommonFridgeFactory();
        Fridge fridge = fridgeFactory.create();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");
        fridge.addIngredient(ingredient);

        // Act & Assert
        assertDoesNotThrow(() -> fridge.checkFridge(ingredient));
    }

    @Test
    public void testCheckFridgeIngredientNotExists() {
        // Arrange
        FridgeFactory fridgeFactory = new CommonFridgeFactory();
        Fridge fridge = fridgeFactory.create();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");

        // Act & Assert
        Exception exception = assertThrows(IngredientNotFoundException.class, () -> {
            fridge.checkFridge(ingredient);
        });

        // Verify the exception message
        Assertions.assertEquals("This ingredient is not in your fridge!", exception.getMessage());
    }
}
