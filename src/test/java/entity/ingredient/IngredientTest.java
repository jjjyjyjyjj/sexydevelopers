package entity.ingredient;

import entity.CommonIngredientFactory;
import entity.Ingredient;
import entity.IngredientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class IngredientTest {

    @Test
    public void testSetUnit() {
        // Arrange
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");
        String newUnit = "g";

        // Act
        ingredient.setUnit(newUnit);

        // Assert
        Assertions.assertEquals(newUnit, ingredient.getUnit());
    }

    @Test
    public void testSetAisle() {
        // Arrange
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");
        String newAisle = "Beverages";

        // Act
        ingredient.setAisle(newAisle);

        // Assert
        Assertions.assertEquals(newAisle, ingredient.getAisle());
    }

    @Test
    public void testSetQuantity() {
        // Arrange
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", 12, "tomato", "fresh");
        double newQuantity = 10.0;

        // Act
        ingredient.setQuantity(newQuantity);

        // Assert
        Assertions.assertEquals(newQuantity, ingredient.getQuantity());
    }
}
