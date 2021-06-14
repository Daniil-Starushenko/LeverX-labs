package com.leverx.task2.service.initialize.dog;

import com.leverx.task2.entity.Dog;

public class DogDrewUpInitializer extends DogInitializer {

    @Override
    public Dog initParam(Dog dog) {
        dog.setDrewUp(isDrewUp(dog.getYearsOld()));
        return checkNext(dog);
    }

    private boolean isDrewUp(int yearsOld) {
        return yearsOld >= 4;
    }
}
