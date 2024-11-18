package interface_adapter.nutritionquery;

public class NutritionState {
    private int calories = 0;
    private int protein = 0;
    private int carbs = 0;
    private boolean maxCarbs = true;
    private boolean maxProteins = false;
    private boolean maxCalories = true;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

}
