package com.leverx.task2.controller;

import com.leverx.task2.entity.Dog;
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

    public ApplicationController() {
        dogCreator = new DogCreator();
    }

    /**
     * methods creates all necessary objects including dogs from 5 to 20
     * and runs the main service method <code></code>
     */
    protected void run() {
        Random random = new Random();
        List<Dog> dogs = new ArrayList<Dog>();
        for (int i = 1; i <= (random.nextInt(20) + 6); i++) {
            dogs.add(dogCreator.initializeDog(i));
        }
        logger.info("dogs are  created");
    }
}
