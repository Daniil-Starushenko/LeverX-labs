package com.leverx.task2.service.initialize.dog;

import com.leverx.task2.entity.Dog;

import java.util.Random;

public class DogHealthInitializer extends DogInitializer {
    @Override
    public Dog initParam(Dog dog) {
        dog.setHealthy(isHealthy());
        dog.setIll();
        return checkNext(dog);
    }

    private boolean isHealthy() {
        Random random = new Random();
        return random.nextInt(2) != 0;
    }
}
