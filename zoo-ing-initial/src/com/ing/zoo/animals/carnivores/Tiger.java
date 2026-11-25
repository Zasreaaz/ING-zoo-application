package com.ing.zoo.animals.carnivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Carnivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Tiger extends Animal implements Carnivore, TrickPerformer {
    private static final Random RANDOM = new Random();

    public Tiger(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "rraaarww";
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + ": nomnomnom oink wubalubadubdub");
    }

    @Override
    public void performTrick() {
        String trick = RANDOM.nextBoolean() ? "jumps in tree" : "scratches ears";
        System.out.println(getName() + " " + trick);
    }
}
