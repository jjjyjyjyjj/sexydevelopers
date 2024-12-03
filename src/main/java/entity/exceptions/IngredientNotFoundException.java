package entity.exceptions;

/**
 * Exceptions for ingredient not found.
 */
public class IngredientNotFoundException extends Exception {
    public IngredientNotFoundException(String message) {
        super(message);
    }
}
