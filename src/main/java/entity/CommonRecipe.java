package entity;

import java.util.List;

/**
 * A recipe
 */
public class CommonRecipe implements Recipe{
    private String name;
    private String id;
    private List<CommonIngredient> ingredients;
    private String image;
    private String link;
//    private ArrayList<Integer> nutrients;


    public CommonRecipe(String name, String id, List<CommonIngredient> ingredients, String image, String link) {
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

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public List<CommonIngredient> getIngredients() {
        return ingredients;
    }

    public String getImage() {
        return image;
    }

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