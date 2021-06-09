package com.leverx.task2.controller;

import com.leverx.task2.entity.*;
import com.leverx.task2.service.Day;
import com.leverx.task2.service.DogCreator;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class <code>ApplicationController</code> is a controller of the app
 * with method <code>run</code> that runs and controls the app
 */
class ApplicationController {
    private static final Logger logger = Logger.getLogger(ApplicationController.class.getName());

    private DogCreator dogCreator;
    private Vet vet;
    private Caretakers caretakers;
    private Trainer trainer;

    public ApplicationController() {
        dogCreator = new DogCreator();
        vet = new Vet();
        caretakers = new Caretakers();
        trainer = new Trainer();
    }

    /**
     * methods creates all necessary objects including dogs from 5 to 20
     * and runs the main service method <code></code>
     */
    protected void run() {
        List<Dog> dogs = new ArrayList<>();
        dogs = initializeDogs();

        List<Aviary> aviaries = new ArrayList<>();
        for (Dog dog : dogs) {
            aviaries.add(new Aviary(dog));
        }

        Day day = new Day(aviaries, dogs, vet, caretakers, trainer);
        day.emulateDay();
    }

    /**
     * method that initialize list of <code>Dog</code> objects
     * @return initialized list of <code>Dog</code> objects
     */
    private List<Dog> initializeDogs() {
        Random random = new Random();
        List<Dog> dogs = new ArrayList<>();
        for (int i = 1; i <= (random.nextInt(20) + 6); i++) {
            dogs.add(dogCreator.initializeDog(i));
        }
        logger.info("dogs are created");
        return dogs;
    }
}
