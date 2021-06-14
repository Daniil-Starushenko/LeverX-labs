package com.leverx.task2.entity;

/**
 * enum that represents types of dogs ages
 * with fields: <b>YOUNG</b>, <b>ADULT</b> and <b>OLD</b>
 */
public enum Age {
    YOUNG("young"),
    ADULT("adult"),
    OLD("old");

    private String value;

    Age(String value) {
        this.value = value;
    }

    public String getAge() {
        return value;
    }

    public static Age getByTag(String value) {
        for (Age age: Age.values()) {
            if (age.getAge().equals(value)) {
                return age;
            }
        }
        return null;
    }

}
