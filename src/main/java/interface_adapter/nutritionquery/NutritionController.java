package use_case.nutrition;

/**
 * Input data for the Nutrition Use Case.
 */
public class NutritionController {

    private int calories;
    private int protein;
    private int carbs;
    private boolean maxCalories;
    private boolean maxProtein;
    private boolean maxCarbs;

    public NutritionController(int calories, int protein, int carbs, boolean maxCalories, boolean maxProtein, boolean maxCarbs) {
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.maxCalories = maxCalories;
        this.maxProtein = maxProtein;
        this.maxCarbs = maxCarbs;

    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public boolean isMaxCalories() {
        return maxCalories;
    }

    public boolean isMaxProtein() {
        return maxProtein;
    }

    public boolean isMaxCarbs() {
        return maxCarbs;
    }
}
