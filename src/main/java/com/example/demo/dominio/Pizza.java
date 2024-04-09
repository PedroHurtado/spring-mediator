package com.example.demo.dominio;

public class Pizza {
    private final String id;
    private final String name;
    protected Pizza(final String id,final String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public static Pizza create(final String id,final String name){
        return new Pizza(id, name);
    }
}
