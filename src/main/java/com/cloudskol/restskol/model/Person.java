package com.cloudskol.restskol.model;

/**
 * @author tham
 */

public class Person {
    private String fName;
    private String lName;

    public Person() {} // Expected by Jackson

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
}
