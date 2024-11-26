package entity;

import java.util.List;

/**
 * A recipe
 */
public final class CommonRecipe implements Recipe{
    private String name;
    private int id;
    private List<Ingredient> ingredients;
    private String image;
    private String link;
//    private ArrayList<Integer> nutrients;


    public CommonRecipe(String name, int id, List<Ingredient> ingredients, String image, String link) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.image = image;
        this.link = link;
//        this.nutrients = new ArrayList<>(3);
//        for (int i = 0; i < 3; i++) {
////            nutrients.add(0);
//        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getLink() {
        return link;
    }

//    public ArrayList<Integer> getNutrients() {
//        return nutrients;
//    }
//
//    public int getCalories() {
//        return nutrients.get(0);
//    }
//
//    public void setCalories(int calories) {
//        nutrients.set(0, calories);
//    }
//
//    public int getProtein() {
//        return nutrients.get(1);
//    }
//
//    public void setProtein(int protein) {
//        nutrients.set(1, protein);
//    }
//
//    public int getCarbs() {
//        return nutrients.get(2);
//    }
//
//    public void setCarbs(int carbs) {
//        nutrients.set(2, carbs);
//    }
}
