package com.leverx.task2.service;

import static com.leverx.task2.entity.Age.OLD;
import static com.leverx.task2.entity.Age.ADULT;
import static com.leverx.task2.entity.Age.YOUNG;

import com.leverx.task2.entity.Age;
import com.leverx.task2.entity.Dog;

import java.util.Random;

/**
 * class <code>DogCreator</code> is class that is needed to initialize
 * in random way objects of <code>Dog</code> class
 */
public class DogCreator {


    /**
     * @return <code>Dog</code> object initialized by specified parameters
     * in random way by using methods below
     */
    public Dog initializeDog(int number) {
        int yearsOld = setYearsOld();

        return new Dog(number,
                age(yearsOld),
                yearsOld,
                isHealthy(),
                true,
                isDrewUp(yearsOld));
    }

    private int setYearsOld() {
        Random random = new Random();
        return (random.nextInt(13) + 1);
    }

    private boolean isHealthy() {
        Random random = new Random();
        return random.nextInt(2) != 0;
    }

    private Age age(int yearsOld) {
        if (yearsOld > 8) {
            return OLD;
        } else if (yearsOld >= 4) {
            return ADULT;
        }
        return YOUNG;
    }

    private boolean isDrewUp(int yearsOld) {
        return yearsOld >= 4;
    }
}
