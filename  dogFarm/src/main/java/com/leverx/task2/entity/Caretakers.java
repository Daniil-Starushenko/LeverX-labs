package com.leverx.task2.entity;

public class Caretakers extends Staff {

    public void feedDog(Dog dog) {
        dog.setHungry(false);
    }

    public void clearAviary(Aviary aviary) {
        aviary.setClear(true);
    }
}
