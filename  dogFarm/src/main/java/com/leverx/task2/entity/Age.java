package com.leverx.task2.entity;

/**
 * enum that represents types of dogs ages
 * with fields: <b>YOUNG</b>, <b>ADULT</b> and <b>OLD</b>
 */
public enum Age {
    YOUNG("young"),
    ADULT("adult"),
    OLD("old");

    private String age;

    Age(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public static Age getByTag(String tag) {
        for (Age age: Age.values()) {
            if (age.getAge().equals(tag)) {
                return age;
            }
        }
        return null;
    }

}
