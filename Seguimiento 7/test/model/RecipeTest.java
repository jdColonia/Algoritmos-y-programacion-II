package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {

    private Recipe list;

    public void setupStage1() {
        list = new Recipe();
    }

    public void setupStage2() {
        list = new Recipe();
        list.addIngredient(new Ingredient("Cebolla", 315));
        list.addIngredient(new Ingredient("Ajo", 58));
        list.addIngredient(new Ingredient("Arroz", 520));
    }

    @Test
    public void addNewIngredientToEmptyListTest() {
        // Arrange
        setupStage1();

        // Act
        list.addIngredient(new Ingredient("Sal", 12));

        // Assert
        assertEquals(list.getSize(), 1);
        assertEquals(list.getLast().getName(), "Sal");
        assertEquals(list.getLast().getWeight(), 12);
    }

    @Test
    public void addNewIngredientTest() {
        // Arrange
        setupStage2();

        // Act
        list.addIngredient(new Ingredient("Pimienta", 6));

        // Assert
        assertEquals(list.getSize(), 4);
        assertEquals(list.getLast().getName(), "Pimienta");
        assertEquals(list.getLast().getWeight(), 6);
    }

    @Test
    public void addIngredientAlreadyAddedTest() {
        // Arrange
        setupStage2();

        // Act
        list.addIngredient(new Ingredient("Ajo", 21));

        // Assert
        assertEquals(list.getSize(), 3);
        assertEquals(list.get(1).getName(), "Ajo");
        assertEquals(list.get(1).getWeight(), 79);
    }


    @Test
    public void removeIngredientTest() {
        // Arrange
        setupStage2();

        // Act
        list.removeIngredient("Ajo");

        // Assert
        assertEquals(list.getSize(), 2);
    }

}
