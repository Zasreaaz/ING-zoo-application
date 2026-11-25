package com.ing.zoo.animals.herbivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Monkey extends Animal implements Herbivore, TrickPerformer {
    private static final Random RANDOM = new Random();

    public Monkey(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "ooh ooh aah aah";
    }

    @Override
    public void eatLeaves() {
        System.out.println(getName() + ": crunch crunch, banana next time?");
    }

    @Override
    public void performTrick() {
        String trick = RANDOM.nextBoolean() ? "swings from branch to branch" : "does a backflip";
        System.out.println(getName() + " " + trick);
    }
}
