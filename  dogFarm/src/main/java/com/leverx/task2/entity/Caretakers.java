package com.leverx.task2.entity;

import org.apache.log4j.Logger;

public class Caretakers implements Staff {
    private static final Logger logger = Logger.getLogger(Caretakers.class.getName());

    public void feedDog(Dog dog) {
        dog.setHungry(false);
        logger.info("dog was feed");
    }

    public void clearAviary(Aviary aviary) {
        aviary.setClear(true);
    }
}
