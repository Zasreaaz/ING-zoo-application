package com.ing.zoo.animals.carnivores;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.behaviours.Carnivore;

public class Lion extends Animal implements Carnivore {
    public Lion(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "roooaoaaaaar";
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + ": nomnomnom thx mate");
    }
}
