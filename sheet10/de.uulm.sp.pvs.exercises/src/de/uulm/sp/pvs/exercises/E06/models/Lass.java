package de.uulm.sp.pvs.exercises.E06.models;

public class Lass extends Person {
    
    public Lass(String name) {
        female = true;
        NAME = name;
    }
    
    @Override
    public String toString() {
        return "LASS { " + NAME + " }";
    }
}
