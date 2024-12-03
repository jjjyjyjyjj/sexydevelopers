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
        Ingredient ingredient = ingredientFactory.create("tomato", "tomato", 1);
        String newUnit = "g";

        // Act
        ingredient.setUnit(newUnit);

        // Assert
        Assertions.assertEquals(newUnit, ingredient.getUnit());
    }

    @Test
    public void testSetQuantity() {
        // Arrange
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = ingredientFactory.create("tomato", "tomato", 1);
        double newQuantity = 10.0;

        // Act
        ingredient.setQuantity(newQuantity);

        // Assert
        Assertions.assertEquals(newQuantity, ingredient.getQuantity());
    }
}
