package com.leverx.task2.service;

import com.leverx.task2.entity.*;

import java.util.List;

public class Day {
    private List<Aviary> aviaries;
    private List<Dog> dogs;
    private Vet vet;
    private Caretakers caretakers;
    private Trainer trainer;

    public Day(List<Aviary> aviaries, List<Dog> dogs, Vet vet, Caretakers caretakers, Trainer trainer) {
        this.aviaries = aviaries;
        this.dogs = dogs;
        this.vet = vet;
        this.caretakers = caretakers;
        this.trainer = trainer;
    }

    public void emulateDay() {

    }
}
