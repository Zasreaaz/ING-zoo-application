package com.ing.zoo.animals.carnivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Carnivore;

public class Wolf extends Animal implements Carnivore {
    public Wolf(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "awoooooo";
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + ": grrr nom nom");
    }
}
