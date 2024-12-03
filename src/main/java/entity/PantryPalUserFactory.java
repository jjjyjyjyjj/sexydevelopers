package entity;

/**
 * Factory for creating CommonUser entities.
 */
public class PantryPalUserFactory implements UserFactory {

    @Override
    public User create(String name, String password) {
        return new PantryPalUser(name, password);
    }
}
