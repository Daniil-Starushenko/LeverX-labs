package com.leverx.task2.controller;

import com.leverx.task2.dal.OutputFileWriter;
import com.leverx.task2.entity.*;
import com.leverx.task2.service.DataParser;
import com.leverx.task2.service.DayEmulator;
import com.leverx.task2.service.initialize.dog.*;
import com.leverx.task2.service.initialize.staff.StaffFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * the main class <code>ApplicationController</code> is a controller of the app
 * with method <code>run</code> that runs and controls the app with writing all necessary info
 * in file with the help of <code>DataParser</code> class and <code>OutputFileWriter</code> class
 */
class ApplicationController {
    private static final Logger logger = Logger.getLogger(ApplicationController.class.getName());

    private DataParser dataParser;
    private OutputFileWriter outputFileWriter;

    public ApplicationController() {
        String outputFilePath = System.getProperty("user.home");
        dataParser = new DataParser();
        outputFileWriter = new OutputFileWriter(outputFilePath);
    }

    protected void run() {
        DayEmulator day = initializeDay();
        logger.info("new day is started: ");
        outputFileWriter.writeOutputFile(Collections.singletonList(System.lineSeparator() + "new day is started:"));

        feeding(day);

        outResult(DayEmulator::healDogs, "dogs have been examined and healed: ", day);

        outputFileWriter.writeOutputFile(Collections.singletonList("aviaries was cleaned: "));
        outputFileWriter.writeOutputFile(day.cleanAviaries());

        outResult(DayEmulator::trainYoungDogs, "young dogs was trained: ", day);

        outResult(DayEmulator::sendToWorkAdultDogs, "adult dogs was send to work: ", day);

        outResult(DayEmulator::leaveOldDogsInAviaries, "old dog left at aviaries: ", day);

        outputFileWriter.writeOutputFile(Collections.singletonList("dogs are hungry: "));
        feeding(day);
    }

    private void feeding(DayEmulator day) {
        outResult(DayEmulator::feedYoungDogs, "young dogs are feed with special food: ", day);

        outResult(DayEmulator::feedAdultDogs, "adult dogs are feed with special food: ", day);

        outResult(DayEmulator::feedOldDogs, "old dogs are feed with special food: ", day);
    }

    private DayEmulator initializeDay() {
        List<Dog> dogs;
        dogs = initializeDogs();

        List<Aviary> aviaries = new ArrayList<>();
        for (Dog dog : dogs) {
            aviaries.add(new Aviary(dog));
        }

        return new DayEmulator(aviaries, dogs, new StaffFactory());
    }


    /**
     * method that initialize list of <code>Dog</code> objects
     * @return initialized list of <code>Dog</code> objects
     */
    private List<Dog> initializeDogs() {
        Random random = new Random();
        List<Dog> dogs = new ArrayList<>();
        DogInitializer dogInitializer = new DogAgeInitializer();
        dogInitializer.linkWith(new DogHealthInitializer())
                .linkWith(new DogDrewUpInitializer());

        for (int i = 1; i <= (random.nextInt(20) + 6); i++) {
            dogs.add(dogInitializer.initParam(new Dog(i)));
        }
        logger.info("dogs are created");
        outputFileWriter.writeOutputFile(dataParser.parseData(dogs, "dog farm contains dogs: "));
        return dogs;
    }

    private void outResult(FarmAction farmAction,
                           String message,
                           DayEmulator day) {
        outputFileWriter.writeOutputFile(
                dataParser.parseData(farmAction.doAction(day), message)
        );
    }
}
