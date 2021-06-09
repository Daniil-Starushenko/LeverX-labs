package com.leverx.task2.controller;

import com.leverx.task2.dal.OutputFileWriter;
import com.leverx.task2.entity.*;
import com.leverx.task2.service.DataParser;
import com.leverx.task2.service.Day;
import com.leverx.task2.service.DogCreator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * the main class <code>ApplicationController</code> is a controller of the app
 * with method <code>run</code> that runs and controls the app
 */
class ApplicationController {
    private static final Logger logger = Logger.getLogger(ApplicationController.class.getName());

    private DogCreator dogCreator;
    private Vet vet;
    private Caretakers caretakers;
    private Trainer trainer;
    private String outputFilePath;
    private Day day;
    private DataParser dataParser;
    private OutputFileWriter outputFileWriter;

    public ApplicationController() {
        dogCreator = new DogCreator();
        vet = new Vet();
        caretakers = new Caretakers();
        trainer = new Trainer();
        outputFilePath = System.getProperty("user.home");
        dataParser = new DataParser();
    }

    /**
     * methods creates all necessary objects including dogs from 5 to 20
     * and runs the main service method <code></code>
     */
    protected void run() {
        outputFileWriter = new OutputFileWriter(outputFilePath);

        day = initializeDay();
        logger.info("day is started");
        outputFileWriter.writeOutputFile(
                dataParser.parseData(day.feedYoungDogs(), "young dogs are feed: ")
        );
    }

    private Day initializeDay() {
        List<Dog> dogs = new ArrayList<>();
        dogs = initializeDogs();

        List<Aviary> aviaries = new ArrayList<>();
        for (Dog dog : dogs) {
            aviaries.add(new Aviary(dog));
        }

        return new Day(aviaries, dogs, vet, caretakers, trainer);
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
