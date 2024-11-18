package entity;

public class DietaryPreferences {

    // Array to hold dietary preference values: calories at index 0, protein at index 1
    private double[] preferences;

    // Constructor to initialize with specified values
    public DietaryPreferences(double calories, double protein) {
        this.preferences = new double[2];
        this.preferences[0] = calories;
        this.preferences[1] = protein;
    }

    // Getter for calories
    public double getCalories() {
        return preferences[0];
    }

    // Setter for calories
    public void setCalories(double calories) {
        this.preferences[0] = calories;
    }

    // Getter for protein
    public double getProtein() {
        return preferences[1];
    }

    // Setter for protein
    public void setProtein(double protein) {
        this.preferences[1] = protein;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Calories: " + preferences[0] + ", Protein: " + preferences[1];
    }
}
