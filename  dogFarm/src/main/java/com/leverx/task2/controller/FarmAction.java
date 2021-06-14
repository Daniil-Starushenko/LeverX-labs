package com.leverx.task2.controller;

import com.leverx.task2.entity.Dog;
import com.leverx.task2.service.DayEmulator;

import java.util.List;

@FunctionalInterface
public interface FarmAction {
    List<Dog> doAction(DayEmulator dayEmulator);
}
