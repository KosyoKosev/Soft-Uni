package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe{
    private List<String> recipeItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... recipeItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

        this.recipeItems = Arrays.asList(recipeItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.recipeItems;
    }
}
