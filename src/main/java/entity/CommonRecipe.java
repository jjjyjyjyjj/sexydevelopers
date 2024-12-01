package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * A recipe
 */
@JsonDeserialize(as = CommonRecipe.class)
public final class CommonRecipe implements Recipe{
    private final String name;
    private final int id;
    private final List<Ingredient> ingredients;
    private final String image;
    private final String link;


    public CommonRecipe(String name, int id, List<Ingredient> ingredients, String image, String link) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.image = image;
        this.link = link;
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

}
