package com.leverx.task2.controller;

import com.leverx.task2.entity.Caretakers;
import com.leverx.task2.entity.Dog;

/**
 * class <code>ApplicationController</code> is a controller of the app
 * with method <code>run</code> that runs and controls the app
 */
class ApplicationController {

    protected void run() {
        Dog dog = new Dog();
        Caretakers caretakers = new Caretakers();
        caretakers.feedDog(dog);
    }
}
