package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * A recipe
 */
@JsonDeserialize(as = CommonRecipe.class)
public final class CommonRecipe implements Recipe{

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients;
    @JsonProperty("image")
    private String image;
    @JsonProperty("link")
    private String link;


    public CommonRecipe(String name, int id, List<Ingredient> ingredients, String image, String link) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.image = image;
        this.link = link;
    }

    public CommonRecipe() {}

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
