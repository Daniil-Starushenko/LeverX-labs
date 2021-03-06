package com.leverx.task2.service.initialize.dog;

import com.leverx.task2.entity.Dog;

/**
 * class <code>DogInitializer</code> is needed to
 * initialize params of <code>Dog</code> object by classes
 * in chain
 */

public abstract class DogInitializer {
    private DogInitializer nextInitializer;

    public DogInitializer linkWith(DogInitializer next) {
        this.nextInitializer = next;
        return next;
    }

    public abstract Dog initParam(Dog dog);

    protected Dog checkNext(Dog dog) {
        if (nextInitializer == null) {
            return dog;
        }
        return nextInitializer.initParam(dog);
    }
}
