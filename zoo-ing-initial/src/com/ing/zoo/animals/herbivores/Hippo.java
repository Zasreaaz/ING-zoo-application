package com.ing.zoo.animals.herbivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Herbivore;

public class Hippo extends Animal implements Herbivore {
    public Hippo(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "splash";
    }

    @Override
    public void eatLeaves() {
        System.out.println(getName() + ": munch munch lovely");
    }
}
