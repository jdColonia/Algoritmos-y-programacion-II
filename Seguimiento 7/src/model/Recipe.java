package model;

import java.util.LinkedList;

public class Recipe {

    private LinkedList<Ingredient> ingredients;

    public Recipe() {
        ingredients = new LinkedList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        Ingredient searched = searchIngredient(ingredient.getName());
        if (searched != null) {
            searched.addWeight(ingredient.getWeight());
        } else {
            ingredients.add(ingredient);
        }
    }

    public void removeIngredient(String objName) {
        Ingredient searched = searchIngredient(objName);
        if (searched != null) {
            ingredients.remove(searched);
        } else {
            return;
        }
    }

    public int getSize() {
        return ingredients.size();
    }

    public Ingredient get(int i) {
        return ingredients.get(i);
    }

    public Ingredient getLast() {
        return ingredients.getLast();
    }

    public Ingredient searchIngredient(String nameObj) {
        Ingredient ingredient = null;
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getName().equals(nameObj)) {
                return ingredient = ingredients.get(i);
            }
        }
        return ingredient;
    }

}