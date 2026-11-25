package com.ing.zoo.animals.omnivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.Carnivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Pig extends Animal implements Herbivore, Carnivore, TrickPerformer {
    private static final Random RANDOM = new Random();

    public Pig(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "oink oink";
    }

    @Override
    public void eatLeaves() {
        System.out.println(getName() + ": munch munch oink");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + ": nomnomnom oink thx");
    }

    @Override
    public void performTrick() {
        String trick = RANDOM.nextBoolean() ? "rolls in the mud" : "runs in circles";
        System.out.println(getName() + " " + trick);
    }
}
