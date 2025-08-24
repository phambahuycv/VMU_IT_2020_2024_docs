package com.example.ki2_2022_2023;

import java.util.Calendar;

public class Category {
    private Integer id;
    private String name;
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
