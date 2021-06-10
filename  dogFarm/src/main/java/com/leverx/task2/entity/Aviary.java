package com.leverx.task2.entity;

/**
 * class <code>Aviaries</code> represents aviaries for every separated dog
 */
public class Aviary {
    private int aviariesNumber;
    private boolean isClear;
    private Dog dog;

    public Aviary(Dog dog) {
        this.dog = dog;
        aviariesNumber = dog.getDogNumber();
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        isClear = clear;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public int getAviariesNumber() {
        return aviariesNumber;
    }

    public void setAviariesNumber(int aviariesNumber) {
        this.aviariesNumber = aviariesNumber;
    }

    @Override
    public String toString() {
        return "Aviary number " +
                aviariesNumber +
                " with dog " +
                dog.getDogNumber() +
                " isClear=" + isClear;
    }
}
