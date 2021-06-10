package com.leverx.task2.service;

import com.leverx.task2.entity.Dog;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public List<String> parseData(List<Dog> dogs, String msg) {
        List<String> parsedInfo = dogsToStringLines(dogs);
        parsedInfo.add(0, msg);
        return parsedInfo;
    }

    private List<String> dogsToStringLines(List<Dog> dogs) {
        List<String> lines = new ArrayList<>();
        dogs.forEach(dog -> lines.add("dog number " + dog.toString()));

        return lines;
    }
}
