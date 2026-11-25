package com.ing.zoo;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.animals.carnivores.Lion;
import com.ing.zoo.animals.carnivores.Tiger;
import com.ing.zoo.animals.carnivores.Wolf;
import com.ing.zoo.animals.herbivores.Hippo;
import com.ing.zoo.animals.herbivores.Monkey;
import com.ing.zoo.animals.herbivores.Zebra;
import com.ing.zoo.animals.omnivores.Pig;
import com.ing.zoo.behaviours.Carnivore;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private static final String HELLO = "hello";
    private static final String GIVE_LEAVES = "give leaves";
    private static final String GIVE_MEAT = "give meat";
    private static final String PERFORM_TRICK = "perform trick";
    private static final String EXIT = "exit";

    private final List<Animal> animals = new ArrayList<>();

    public Zoo() {
        animals.add(new Lion("henk"));
        animals.add(new Hippo("elsa"));
        animals.add(new Pig("dora"));
        animals.add(new Tiger("wally"));
        animals.add(new Zebra("marty"));
        animals.add(new Monkey("george"));
        animals.add(new Wolf("akela"));
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Commands: hello [naam of soort], give leaves [naam of soort], "
                + "give meat [naam of soort], perform trick, exit");
        while (true) {
            System.out.print("Voer uw command in: ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals(EXIT)) {
                break;
            }
            zoo.handleCommand(input);
        }
    }

    public void handleCommand(String input) {
        if (input.equals(HELLO)) {
            animals.forEach(Animal::sayHello);
        } else if (input.startsWith(HELLO + " ")) {
            sayHelloTo(getArgument(input, HELLO));
        } else if (input.equals(GIVE_LEAVES)) {
            giveLeavesToAll();
        } else if (input.startsWith(GIVE_LEAVES + " ")) {
            giveLeavesTo(getArgument(input, GIVE_LEAVES));
        } else if (input.equals(GIVE_MEAT)) {
            giveMeatToAll();
        } else if (input.startsWith(GIVE_MEAT + " ")) {
            giveMeatTo(getArgument(input, GIVE_MEAT));
        } else if (input.equals(PERFORM_TRICK)) {
            for (Animal animal : animals) {
                if (animal instanceof TrickPerformer) {
                    ((TrickPerformer) animal).performTrick();
                }
            }
        } else {
            System.out.println("Unknown command: " + input);
        }
    }

    private void sayHelloTo(String nameOrSpecies) {
        for (Animal animal : findAnimals(nameOrSpecies)) {
            animal.sayHello();
        }
    }

    private void giveLeavesToAll() {
        for (Animal animal : animals) {
            if (animal instanceof Herbivore) {
                ((Herbivore) animal).eatLeaves();
            }
        }
    }

    private void giveLeavesTo(String nameOrSpecies) {
        for (Animal animal : findAnimals(nameOrSpecies)) {
            if (animal instanceof Herbivore) {
                ((Herbivore) animal).eatLeaves();
            } else {
                System.out.println(animal.getName() + ": leaves? Sorry, I'm a carnivore, I only eat meat!");
            }
        }
    }

    private void giveMeatToAll() {
        for (Animal animal : animals) {
            if (animal instanceof Carnivore) {
                ((Carnivore) animal).eatMeat();
            }
        }
    }

    private void giveMeatTo(String nameOrSpecies) {
        for (Animal animal : findAnimals(nameOrSpecies)) {
            if (animal instanceof Carnivore) {
                ((Carnivore) animal).eatMeat();
            } else {
                System.out.println(animal.getName() + ": meat? Sorry, I'm a herbivore, I don't eat meat!");
            }
        }
    }

    /**
     * Zoekt dieren op naam (bijv. "marty") of op soort (bijv. "zebra").
     * Print een melding als er geen dier gevonden is.
     */
    private List<Animal> findAnimals(String nameOrSpecies) {
        List<Animal> found = new ArrayList<>();
        for (Animal animal : animals) {
            boolean nameMatches = animal.getName().equalsIgnoreCase(nameOrSpecies);
            boolean speciesMatches = animal.getClass().getSimpleName().equalsIgnoreCase(nameOrSpecies);
            if (nameMatches || speciesMatches) {
                found.add(animal);
            }
        }
        if (found.isEmpty()) {
            System.out.println("Er is geen dier met de naam of soort: " + nameOrSpecies);
        }
        return found;
    }

    private String getArgument(String input, String command) {
        return input.substring(command.length()).trim();
    }
}
