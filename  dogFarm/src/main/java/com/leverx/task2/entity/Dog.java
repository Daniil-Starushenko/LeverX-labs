package com.leverx.task2.entity;

/**
 * class <code>Dog</code> is class that represent characteristics
 * and behavior of Dog's objects withs fields <b>age</b>, <b>yearsOld</b>, <b>isHealthy</b>
 * @author danik;
 */
public class Dog {
    private int dogNumber;
    private Age age;
    private int yearsOld;
    private boolean isHealthy;
    private boolean isHungry;
    private boolean isDrewUp;

    public Dog(int dogNumber, Age age, int yearsOld, boolean isHealthy, boolean isHungry, boolean isDrewUp) {
        this.dogNumber = dogNumber;
        this.age = age;
        this.yearsOld = yearsOld;
        this.isHealthy = isHealthy;
        this.isHungry = isHungry;
        this.isDrewUp = isDrewUp;
    }

    public Dog() {}

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public boolean isDrewUp() {
        return isDrewUp;
    }

    public void setDrewUp(boolean drewUp) {
        isDrewUp = drewUp;
    }

    public int getDogNumber() {
        return dogNumber;
    }

    public void setDogNumber(int dogNumber) {
        this.dogNumber = dogNumber;
    }
}
