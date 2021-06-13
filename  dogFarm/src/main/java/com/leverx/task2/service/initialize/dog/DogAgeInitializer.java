package com.leverx.task2.service.initialize.dog;

import com.leverx.task2.entity.Age;
import com.leverx.task2.entity.Dog;

import java.util.Random;

import static com.leverx.task2.entity.Age.OLD;
import static com.leverx.task2.entity.Age.ADULT;
import static com.leverx.task2.entity.Age.YOUNG;

public class DogAgeInitializer extends DogInitializer {

    @Override
    public boolean initParam(Dog dog) {
        int yearsOld = yearsOld();

        dog.setYearsOld(yearsOld);
        dog.setAge(age(yearsOld));
        return checkNext(dog);
    }

    private int yearsOld() {
        Random random = new Random();
        return (random.nextInt(13) + 1);
    }

    private Age age(int yearsOld) {
        if (yearsOld > 8) {
            return OLD;
        } else if (yearsOld >= 4) {
            return ADULT;
        }
        return YOUNG;
    }
}
