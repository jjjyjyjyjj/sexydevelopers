package entity.fridge;

import entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class FridgeTest {
    private FridgeFactory fridgefactory;
    private Fridge fridge;

    @Test
    public void testAddIngredient() {
        // Arrange
        Fridge fridge = new CommonFridge();
        Ingredient ingredient = new CommonIngredient("tomato", 12, "tomato", "fresh");

        // Act
        fridge.addIngredient(ingredient);

        // Assert
        assertTrue(fridge.getIngredients().contains(ingredient));
    }
}
