package com.company.data;

public class Person implements IInfo {
    static int nInstances = 0;
    protected String name;
    String id;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
        nInstances++;
        System.out.printf("Instances: %d\n", nInstances);
    }

    @Override
    public void info() {
        System.out.printf("ID: %s, Name: %s\n", id, name);
    }
}
