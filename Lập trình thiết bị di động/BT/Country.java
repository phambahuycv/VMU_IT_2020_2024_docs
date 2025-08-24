package com.example.ki2_2022_2023;

public class Country {
    private String code;
    private String name;
    private String color;
    public Country(String code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
}
