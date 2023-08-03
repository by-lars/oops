package de.uulm.sp.pvs.exercises.E06.models;

public class Lad extends Person {
    
    public Lad(String name) {
        female = false;
        NAME = name;
    }
    
    @Override
    public String toString() {
        return "LAD { " + NAME + " }";
    }
}
