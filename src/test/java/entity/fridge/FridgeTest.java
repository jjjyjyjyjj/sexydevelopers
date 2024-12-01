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
        Ingredient ingredient = IngredientFactory.create("tomato",  "tomato", 1);

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
        Ingredient ingredient = IngredientFactory.create("tomato", "tomato", 1);

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
        Ingredient ingredient = IngredientFactory.create("tomato", "tomato", 1);
        fridge.addIngredient(ingredient);

        // Act
        fridge.removeIngredient("tomato");

        // Assert
        Assertions.assertFalse(fridge.getIngredients().contains(ingredient));
    }

}
