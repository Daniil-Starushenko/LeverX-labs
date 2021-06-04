package com.leverx.task2.entity;

public class Vet extends Staff {

    public void examineDog(Dog dog) {
        if (!dog.isHealthy()) {
            cureDog(dog);
        }
    }

    private void cureDog(Dog sickDog) {
        sickDog.setHealthy(true);
    }
}
