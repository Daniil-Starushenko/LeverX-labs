package com.leverx.task2.service;

import com.leverx.task2.entity.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class <code>Day</code> emulates day with method <code>emulateDay</code>
 * and writes info into output file with <code>FileParser</code> class
 */
public class DayEmulator {
    private static final Logger logger = Logger.getLogger(DayEmulator.class.getName());

    private FilterDogs filterDogs;
    private List<Aviary> aviaries;
    private List<Dog> dogs;
    private Vet vet;
    private Caretakers caretakers;
    private Trainer trainer;

    public DayEmulator(List<Aviary> aviaries, List<Dog> dogs, Vet vet, Caretakers caretakers, Trainer trainer) {
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
        List<Dog> adultDogs = FilterDogs.filterByAge(dogs, Age.ADULT);
        adultDogs.forEach(dog -> caretakers.feedDog(dog));

        return adultDogs;
    }

    public List<Dog> feedOldDogs() {
        List<Dog> oldDogs = FilterDogs.filterByAge(dogs, Age.OLD);
        oldDogs.forEach(dog -> caretakers.feedDog(dog));

        return oldDogs;
    }

    public List<Dog> healDogs() {
        List<Dog> illDogs = FilterDogs.filterByHealth(dogs, false);
        illDogs.forEach(dog -> vet.examineDog(dog));

        return illDogs;
    }

    public List<String> cleanAviaries() {
        List<String> cleanAviaries = new ArrayList<>();
        aviaries.forEach(aviary -> caretakers.clearAviary(aviary));
        aviaries.forEach(aviary -> cleanAviaries.add(aviary.toString()));

        return cleanAviaries;
    }

    public List<Dog> trainYoungDogs() {
        List<Dog> dogsToTrain = FilterDogs.filterByAge(dogs, Age.YOUNG);
        dogsToTrain.forEach(dog -> trainer.trainDog(dog));
        dogsToTrain.forEach(dog -> dog.setHungry(true));
        return dogsToTrain;
    }

    public List<Dog> sendToWorkAdultDogs() {
        List<Dog> dogsToWork = FilterDogs.filterByAge(dogs, Age.ADULT);
        dogsToWork.forEach(dog -> dog.setJob(chooseJobRandomly()));
        dogsToWork.forEach(dog -> dog.setHungry(true));
        return dogsToWork;
    }

    private Job chooseJobRandomly() {
        Random random = new Random();
        switch(random.nextInt(2)) {
            case 0:
                return Job.EMERGENCY;
            case 1:
                return Job.POLICE;
        }
        return Job.POLICE; //default
    }

    public List<Dog> leaveOldDogsInAviaries() {
        List<Dog> oldDogs =  FilterDogs.filterByAge(dogs, Age.OLD);
        oldDogs.forEach(dog -> dog.setHungry(true));
        return oldDogs;
    }

}
