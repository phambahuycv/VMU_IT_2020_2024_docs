package com.company;

import com.company.data.Person;

public class Worker extends Person {
    String w;
    public Worker(String id, String name, String w) {
        super(id, name);
        this.w = w;
    }

    @Override
    public void info() {
        System.out.println("Name:" + name + " | w: " + w);
    }
}
