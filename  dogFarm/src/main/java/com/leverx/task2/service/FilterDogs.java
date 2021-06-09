package com.leverx.task2.service;

import com.leverx.task2.entity.Age;
import com.leverx.task2.entity.Dog;

import java.util.List;
import java.util.stream.Collectors;

public class FilterDogs {
    public static List<Dog> filterByAge(List<Dog> dogs, Age age)  {
        return dogs.stream()
                    .filter(dog -> dog.getAge() == age)
                    .collect(Collectors.toList());
    }
}
