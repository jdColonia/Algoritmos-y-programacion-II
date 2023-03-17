package model;

import exceptions.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    private Ingredient ingredient1;

    public void setupStage1() {
        ingredient1 = new Ingredient("Tomate", 245);
    }

    @Test
    public void positiveWeightIsAddedToIngredientTest() {
        // Arrange
        setupStage1();

        // Act
        ingredient1.addWeight(54);

        // Assert
        assertEquals(ingredient1.getWeight(), 299);
    }

    @Test
    public void negativeWeightIsAddedToIngredientTest() {
        // Arrange
        setupStage1();

        // Act + Assert
        assertThrows(InvalidNumberException.class, ()->{
            ingredient1.addWeight(-100);
        });
    }

    @Test
    public void positiveWeightIsRemovedToIngredientTest() {
        // Arrange
        setupStage1();

        // Act
        ingredient1.removeWeight(45);

        // Assert
        assertEquals(ingredient1.getWeight(), 200);
    }

    @Test
    public void negativeWeightIsRemovedToIngredientTest() {
        // Arrange
        setupStage1();

        // Act + Assert
        assertThrows(InvalidNumberException.class, ()->{
            ingredient1.removeWeight(-100);
        });
    }

}
