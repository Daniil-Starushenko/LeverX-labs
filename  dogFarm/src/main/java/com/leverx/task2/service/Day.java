package com.leverx.task2.service;

import com.leverx.task2.entity.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class <code>Day</code> emulates day with method <code>emulateDay</code>
 * and writes info into output file with <code>FileParser</code> class
 */
public class Day {
    private static final Logger logger = Logger.getLogger(Day.class.getName());

    private List<Aviary> aviaries;
    private List<Dog> dogs;
    private Vet vet;
    private Caretakers caretakers;
    private Trainer trainer;

    public Day(List<Aviary> aviaries, List<Dog> dogs, Vet vet, Caretakers caretakers, Trainer trainer) {
        this.aviaries = aviaries;
        this.dogs = dogs;
        this.vet = vet;
        this.caretakers = caretakers;
        this.trainer = trainer;
    }

    public List<Dog> feedYoungDogs() {
        new FilterDogs();
        List<Dog> youngDogs = FilterDogs.filterByAge(dogs, Age.YOUNG);
        youngDogs.forEach(dog -> caretakers.feedDog(dog));

        return youngDogs;
    }

    public List<Dog> feedAdultDogs() {
        new FilterDogs();
        List<Dog> adultDogs = FilterDogs.filterByAge(dogs, Age.ADULT);
        adultDogs.forEach(dog -> caretakers.feedDog(dog));

        return adultDogs;
    }

    public List<Dog> feedOldDogs() {
        new FilterDogs();
        List<Dog> oldDogs = FilterDogs.filterByAge(dogs, Age.OLD);
        oldDogs.forEach(dog -> caretakers.feedDog(dog));

        return oldDogs;
    }


}
