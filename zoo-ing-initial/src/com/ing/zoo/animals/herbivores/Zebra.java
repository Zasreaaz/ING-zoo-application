package com.ing.zoo.animals.herbivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Herbivore;

public class Zebra extends Animal implements Herbivore {
    public Zebra(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "zebra zebra";
    }

    @Override
    public void eatLeaves() {
        System.out.println(getName() + ": munch munch zank yee bra");
    }
}
