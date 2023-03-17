package model;

import exceptions.InvalidNumberException;

public class Ingredient {

    private String name;
    private double weight;

    public Ingredient(String n, double w) {
        name = n;
        weight = w;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void addWeight(double additionalW) throws InvalidNumberException {
        if (additionalW < 0) {
            throw new InvalidNumberException();
        } else {
            weight += additionalW;
        }
    }

    public void removeWeight(double removeW) throws InvalidNumberException {
        if (removeW < 0) {
            throw new InvalidNumberException();
        } else {
            weight -= removeW;
        }
    }

}
